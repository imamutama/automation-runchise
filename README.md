
## Prerequisites
* Java JDK 11 or higher installed
* Maven installed
* Android real device (or emulator) connected and accessible
* Install Appium
* Setup environment variable SDK

## Setup
Clone the repository: 
```console
git clone https://github.com/imamutama/mobile-surplus-cucumber.git
```
* Start Appium Driver

## Configuration
Open the android-real-devices.json file in the project's capabilities-json/android-real-device.json resources directory.
Set the value of json:

```console
{
  "platformName": "Android",
  "deviceName": "oreo",
  "platformVersion": "8.1.0",
  "udid": "4b9621ae",
  "autoGrantPermissions": true,
  "noReset": false,
  "UiAutomatorName": "UiAutomator2",
  "chromedriverExecutable": "C:\\Users\\utama\\IdeaProjects\\automation-salesforce\\chromedriver.exe",
  "browserName": "chrome"
}
```
## Running Tests
To run the automation tests, use the following command:
```console
$ mvn clean test -Dcucumber.filter.tags="@add-product" -Denv.PLATAFORM=ANDROID_REAL_DEVICE
```
This command will execute the tests tagged with @smoke-test on an Android real device.

