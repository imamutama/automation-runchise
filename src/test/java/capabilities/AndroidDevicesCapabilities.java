package capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

public enum AndroidDevicesCapabilities {
    ANDROID_REAL_DEVICE("capabilities-json/android-real-device.json");
    private final String path;

    AndroidDevicesCapabilities(String path) {
        this.path = path;
    }

    public DesiredCapabilities getAndroidCapabilitiesFromPlataform() {
        DesiredCapabilities androidCapabilities = LoadCapabilities.pathToDesiredCapabilitites(this.path);
        return androidCapabilities;
    }

    public static void showAvaliableAndroidDevices() {
        System.out.println("======= ANDROID DEVICES ====== ");
        for (AndroidDevicesCapabilities androidDevicesCapabilities : AndroidDevicesCapabilities.values()) {
            System.out.println(androidDevicesCapabilities.name());
        }
    }
}
