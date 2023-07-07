package capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public enum AndroidDevicesCapabilities {
    ANDROID_REAL_DEVICE("capabilities-json/android-real-device.json");
    private final String path;

    AndroidDevicesCapabilities(String path) {
        this.path = path;
    }

    public DesiredCapabilities getAndroidCapabilitiesFromPlatform() {
        DesiredCapabilities androidCapabilities = LoadCapabilities.pathToDesiredCapabilitites(this.path);
          androidCapabilities.setCapability("chromedriverExecutable", new File("chromedriver.exe").getAbsolutePath());
        return androidCapabilities;
    }

    public static void showAvaliableAndroidDevices() {
        System.out.println("======= ANDROID DEVICES ====== ");
        for (AndroidDevicesCapabilities androidDevicesCapabilities : AndroidDevicesCapabilities.values()) {
            System.out.println(androidDevicesCapabilities.name());
        }
    }
}
