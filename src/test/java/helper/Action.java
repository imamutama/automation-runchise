package helper;

import capabilities.DriverFactoryManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
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

    public void waitElementDisplayed(Direction dir, String elementBy) throws Exception {
        try {
            implicitWait();
            driver.findElement(byDirection(dir, elementBy)).isDisplayed();
        } catch (Exception e) {
            throw new Exception("Element " + elementBy + " is cannot displayed in page");
        }
    }

    public boolean verifyTextElement(String text) {
        try {
            implicitWait();
            return driver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']")).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException("Element " + text + " is cannot displayed in page");
        }
    }

    public void click(Direction dir, String elementBy) throws Exception {
        waitElementDisplayed(dir, elementBy);
        driver.findElement(byDirection(dir, elementBy)).click();
    }

    public void clickByText(String text) {
        verifyTextElement(text);
        driver.findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public void sendText(Direction dir, String elementBy, String text) throws Exception {
        waitElementDisplayed(dir, elementBy);
        driver.findElement(byDirection(dir, elementBy)).sendKeys(text);
    }

    public String getText(Direction dir, String elementBy) {
        return driver.findElement(byDirection(dir, elementBy)).getText();
    }

    public void backAndroid() {
        driver.navigate().back();
    }


//    public boolean verifyElementDisable(Direction dir, String element) {
//        WebElement input = driver.findElement(byDirection(dir, element));
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        return (boolean) executor.executeScript("return arguments[0].disabled", input);
//    }
//
//    public static void changeDriverContextToWeb(AppiumDriver driver) {
//        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
//        for (String contextName : contextNames) {
//            if (contextName.contains("WEBVIEW"))
//                ((SupportsContextSwitching) driver).context(contextName);
//        }
//    }
//
//    public static void changeDriverContextToNative(AppiumDriver driver) {
//        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
//        for (String contextName : contextNames) {
//            if (contextName.contains("NATIVE"))
//                ((SupportsContextSwitching) driver).context(contextName);
//        }
//    }
//
//    private static boolean isNotEndOfPage(String previousPageSource) {
//        return !previousPageSource.equals(driver.getPageSource());
//    }
//
//    private boolean isElementNotEnabled(Direction dir, String elementBy) {
//        try {
//            return !driver.findElement(byDirection(dir, elementBy)).isDisplayed();
//        } catch (NoSuchElementException e) {
//            return true;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void performScroll() throws InterruptedException {
//        Thread.sleep(2000);
//        Dimension size = driver.manage().window().getSize();
//        int startX = (int) (size.width * 0.5);
//        int startY = (int) (size.height * 0.9);
//        int endX = (int) (size.width * 0.5);
//        int endY = (int) (size.height * 0.2);
//        performScrollUsingSequence(startX, startY, endX, endY);
//    }
//
//    public void tapCordinate() throws InterruptedException {
//        Thread.sleep(1000);
//        Dimension size = driver.manage().window().getSize();
//        System.out.println("index :" + size);
//        int startX = (int) (size.width * 0.5);
//        System.out.println("index :" + startX);
//        int endY = (int) (size.height - 100);
//        System.out.println("index :" + endY);
//        clickOnPosition(startX, endY);
//    }
//
//    public void clickOnPosition(int pointA_X, int pointA_Y) throws InterruptedException {
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence clickPosition = new Sequence(finger, 1);
//        clickPosition.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), pointA_X, pointA_Y))
//                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(clickPosition));
//    }
//
//    private static void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
//        Sequence sequence = new Sequence(finger, 0)
//                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
//                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
//                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        ((AppiumDriver) (driver)).perform(Collections.singletonList(sequence));
//    }
//
//    public void selectDropdown(Direction dir, String element, String valueSearch, String valueDrop) throws
//            Exception {
//        implicitWait();
//        sendText(dir, element, valueSearch);
//        clickByTextAndroid(valueDrop);
//    }
//
//    public String getTextJsExecutor(Direction dir, String element) throws Exception {
//        changeDriverContextToWeb(driver);
//        WebElement input = driver.findElement(byDirection(dir, element));
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        return (String) executor.executeScript("return arguments[0].value;", input);
//    }
//
//    public void backAndroid() {
//        driver.navigate().back();
//    }
//
//    public void scrollByText(String visibleText) {
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))"));
//    }
//
//    public static By uploadImage(By text, String path) {
//        WebElement input = driver.findElement(text);
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].type='file'", input);
//        input.sendKeys(path);
//        return text;
//    }
//
//    public void setAndroidDatePicker(String date) throws ParseException {
//        changeDriverContextToNative(driver);
//        int thisYear = Integer.valueOf(driver.findElement(By.id("android:id/date_picker_header_year")).getAttribute("name"));
//        String today = driver.findElement(By.id("android:id/date_picker_header_date")).getAttribute("name");
//        int thisMonth = GeneratedDate.getMonthNumber(GeneratedDate.getMonthNameInThreeChars(today, today.length()));
//        String[] splitdate = date.split("\\s+");
//
//        int givenDay = Integer.valueOf(splitdate[0]);
//        int givenMonth = GeneratedDate.getMonthNumber(splitdate[1]);
//        int givenYear = Integer.valueOf(splitdate[2]);
//
//        int forwardTaps = 0;
//        int backwardTaps = 0;
//        int yearFactor = 0;
//
//        if (givenYear == thisYear) {
//            if (givenMonth >= thisMonth) {
//                forwardTaps = givenMonth - thisMonth;
//            } else {
//                backwardTaps = thisMonth - givenMonth;
//            }
//        } else if (givenYear > thisYear) {
//            yearFactor = (givenYear - thisYear) * 12;
//            if (givenMonth >= thisMonth) {
//                forwardTaps = yearFactor + (givenMonth - thisMonth);
//            } else {
//                forwardTaps = yearFactor - (thisMonth - givenMonth);
//            }
//        } else {
//            yearFactor = (thisYear - givenYear) * 12;
//            if (givenMonth >= thisMonth) {
//                backwardTaps = yearFactor - (givenMonth - thisMonth);
//            } else {
//                backwardTaps = yearFactor + (thisMonth - givenMonth);
//            }
//        }
//
//        for (int i = 1; i <= forwardTaps; i++) {
//            driver.findElement(By.id("android:id/next")).click();
//        }
//
//        for (int i = 1; i <= backwardTaps; i++) {
//            driver.findElement(By.id("android:id/prev")).click();
//        }
//
//        String xpath = "//android.view.View[@text='day']";
//        driver.findElement(By.xpath(xpath.replace("day", String.valueOf(givenDay)))).click();
//        driver.findElement(By.id("android:id/button1")).click();
//
//    }
//
//    public void select(Direction dir, String elementBy, Consumer<Select> consumer) {
//        consumer.accept(new Select(driver.findElement(byDirection(dir, elementBy))));
//    }
//
//
//    public boolean verifyTextElementNative(String text) {
//        changeDriverContextToNative(driver);
//        try {
//            implicitWait();
//            return driver.findElement(By.xpath("//*[@text='" + text + "']")).isDisplayed();
//        } catch (Exception e) {
//            throw new RuntimeException("Element " + text + " is cannot displayed in page");
//        }
//    }
//
//    public String getAttribute(Direction dir, String elementBy, Function<WebElement, String> attributeFunction) {
//        return attributeFunction.apply(driver.findElement(byDirection(dir, elementBy)));
//    }
//
//    public boolean isPresent(Direction dir, String elementBy, Predicate<WebElement> elementPredicate) {
//        return elementPredicate.test(driver.findElement(byDirection(dir, elementBy)));
//    }
//
//    public void scrollForMobile(Direction dir, String elementBy) throws InterruptedException {
//        String previousPageSource = "";
//        while (isElementNotEnabled(dir, elementBy) && isNotEndOfPage(previousPageSource)) {
//            previousPageSource = driver.getPageSource();
//            performScroll();
//        }
//    }
//
//    public void datePickerSetClick(String element) {
//        changeDriverContextToNative(driver);
//        driver.findElement(By.id(element)).click();
//    }
//
//    public void clickByNative(Direction dir, String element) {
//        implicitWait();
//        changeDriverContextToNative(driver);
//        driver.findElement(byDirection(dir, element)).click();
//    }
//
//    public static By jsSelector(By s) {
//        changeDriverContextToWeb(driver);
//        WebElement elementToSelect = driver.findElement(s);
//        elementToSelect.click();
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();", elementToSelect);
//        return s;
//    }
//
//    public static By sendTextJs(By s, String text) {
//        WebElement inputField = driver.findElement(s);
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].value='text';", inputField);
//        return s;
//    }
//
//    public void enterDown() {
//        Actions keyDown = new Actions(driver);
//        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
//    }
//
//    public void clickValueDropdown(String element, String value) throws InterruptedException {
//        Thread.sleep(2000);
//        List<WebElement> elements = driver.findElements(By.xpath(element));
//        for (WebElement e : elements) {
//            if (value.contains(e.getText())) {
//                e.click();
//                System.out.println("Get Value Dropdown : " + e.getText());
//            }
//        }
//    }


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

    public void ctrlADelete(Direction dir, String elementBy) throws Exception {
        waitElementDisplayed(Direction.XPATH, elementBy);
        String act = Keys.chord(Keys.CONTROL, "a", Keys.DELETE);
        WebElement field = driver.findElement(byDirection(dir, elementBy));
        field.sendKeys(act);
    }

    public boolean classIsActive(String classname, int index, String text) {
        try {
            implicitWait();
            driver.findElement(By.xpath("//*[@class='" + classname + "']['" + index + "']/*[text()='" + text + "']")).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException("Element " + text + " is cannot displayed in page");
        }
        return true;
    }

    public boolean isDisabled(String elementBy) {
        driver.findElement(By.xpath("//*[@class=" + elementBy + " and @disabled]")).isDisplayed();
        return true;
    }

}
