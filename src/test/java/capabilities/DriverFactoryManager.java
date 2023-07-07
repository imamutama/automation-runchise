package capabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactoryManager {
    private static AppiumDriver Driver;
    private static AppiumDriverLocalService service;

    public static AppiumDriver startDriverByMavenParameter(String mavenEnvironment) {
        try {
            if (mavenEnvironment.contains("ANDROID")) {
                Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), AndroidDevicesCapabilities.valueOf(mavenEnvironment).getAndroidCapabilitiesFromPlatform());
            } else if (mavenEnvironment.contains("IPHONE")) {
                System.out.println("not running ios");
            }
        } catch (IllegalArgumentException e) {
            AndroidDevicesCapabilities.showAvaliableAndroidDevices();
            System.exit(1);
        } catch (UnreachableBrowserException e) {
            System.exit(1);
        } catch (MalformedURLException e) {
            System.exit(1);
        }

        return Driver;
    }

    public static AppiumDriver getDriver() {
        return Driver;
    }

    public static void quitDriver() {
        if (Driver != null) {
            Driver.manage().deleteAllCookies();
            Driver.quit();
        }
    }

    public static void clear() {
        if (Driver != null) {
            Driver.manage().deleteAllCookies();
        }
    }

    public static String getPageHierarchy() {
        return Driver.getPageSource();
    }
}

