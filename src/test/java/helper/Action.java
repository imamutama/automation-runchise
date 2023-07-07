package helper;

import capabilities.DriverFactoryManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Action {
    public static AppiumDriver driver;

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public Action() {
        this.driver = new DriverFactoryManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void waitElementDisplayed(Direction dir, String elementBy) throws Exception {
        changeDriverContextToWeb(driver);
        try {
            implicitWait();
            driver.findElement(byDirection(dir, elementBy)).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Element " + elementBy + " is cannot displayed in page");
        }
    }

    public boolean verifyTextElement(String text) {
        changeDriverContextToWeb(driver);
        try {
            implicitWait();
            return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void click(Direction dir, String elementBy) throws Exception {
        changeDriverContextToWeb(driver);
        waitElementDisplayed(Direction.XPATH, elementBy);
        driver.findElement(byDirection(dir, elementBy)).click();
    }

    public void clickByText(String text) {
        changeDriverContextToWeb(driver);
        verifyTextElement(text);
        driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).click();
    }

    public void clickByTextAndroid(String text) {
        implicitWait();
        changeDriverContextToNative(driver);
        driver.findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public void sendText(Direction dir, String elementBy, String text) throws Exception {
        changeDriverContextToWeb(driver);
        waitElementDisplayed(Direction.XPATH, elementBy);
        driver.findElement(byDirection(dir, elementBy)).sendKeys(text);
    }


    public static void changeDriverContextToWeb(AppiumDriver driver) {
        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
        System.out.println("get context: " + contextNames);
        for (String contextName : contextNames) {
            if (contextName.contains("CHROMIUM"))
                ((SupportsContextSwitching) driver).context(contextName);
        }
    }

    public static void changeDriverContextToNative(AppiumDriver driver) {
        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE"))
                ((SupportsContextSwitching) driver).context(contextName);
        }
    }

    private static boolean isNotEndOfPage(String previousPageSource) {
        return !previousPageSource.equals(driver.getPageSource());
    }

    private boolean isElementNotEnabled(Direction dir, String elementBy) {
        try {
            return !driver.findElement(byDirection(dir, elementBy)).isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void performScroll() throws InterruptedException {
        Thread.sleep(2000);
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int startY = (int) (size.height * 0.9);
        int endX = (int) (size.width * 0.5);
        int endY = (int) (size.height * 0.2);
        performScrollUsingSequence(startX, startY, endX, endY);
    }

    public void clickOnPosition(int pointA_X, int pointA_Y) throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence clickPosition = new Sequence(finger, 1);
        clickPosition.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), pointA_X, pointA_Y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(clickPosition));

    }

    private static void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (driver)).perform(Collections.singletonList(sequence));
    }


    public String getText(Direction dir, String element) {
        return driver.findElement(byDirection(dir, element)).getText();
    }

    public void scrollElement(String elementID) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(elementID));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public By byDirection(Direction dir, String element) {
        By by = null;
        switch (dir) {
            case XPATH:
                by = By.xpath(element);
                break;
            case ID:
                by = By.id(element);
                break;
            case CSS:
                by = By.cssSelector(element);
                break;
            case CLASSNAME:
                by = By.className(element);
                break;
            case LINKTEXT:
                by = By.linkText(element);
                break;
            case ACCESSBILITYID:
                by = AppiumBy.accessibilityId(element);
        }
        return by;
    }

    public enum Direction {
        XPATH,
        ID,
        CSS,
        CLASSNAME,
        LINKTEXT,
        ACCESSBILITYID
    }

}
