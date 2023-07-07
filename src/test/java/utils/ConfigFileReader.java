package util;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "application.properties";
    private static final File FILE = new File(System.getProperty("user.dir") + "/src/test/resources/file/ktp.jpg");

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public void writeFileText(String validationText, String File) {
        try {
            File file = new File(File);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(validationText);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFileText(String FileRead) {
        String textRead = null;
        try {
            FileReader reader = new FileReader(FileRead);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                textRead = line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textRead;
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getPathFile() {
        return FILE.getAbsolutePath();
    }

    public long getTimeout() {
        String timeout = properties.getProperty("wait.timeout");
        if (timeout != null) return Long.parseLong(timeout);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public long getSleep() {
        String sleep = properties.getProperty("wait.sleep");
        if (sleep != null) return Long.parseLong(sleep);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("base.url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getApiUrl() {
        String url = properties.getProperty("api.url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getDashboardUsername() {
        String data = properties.getProperty("dashboard.username");
        if (data != null) return data;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getDashboardPass() {
        String data = properties.getProperty("dashboard.password");
        if (data != null) return data;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getDeviceId() {
        String deviceId = properties.getProperty("device.id");
        if (deviceId != null) return deviceId;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getValidPhone() {
        String phone = properties.getProperty("user.phone");
        if (phone != null) return phone;
        else throw new RuntimeException("phone not specified in the Configuration.properties file.");
    }

    public String getValidPIN() {
        String pin = properties.getProperty("user.pin");
        if (pin != null) return pin;
        else throw new RuntimeException("pin not specified in the Configuration.properties file.");
    }

    public String getInvalidPhone() {
        String phone = properties.getProperty("user.invalid.phone");
        if (phone != null) return phone;
        else throw new RuntimeException("phone not specified in the Configuration.properties file.");
    }

    public String getInvalidPIN() {
        String pin = properties.getProperty("user.invalid.pin");
        if (pin != null) return pin;
        else throw new RuntimeException("pin not specified in the Configuration.properties file.");
    }

    public String getOTP() {
        String otp = properties.getProperty("user.valid.otp");
        if (otp != null) return otp;
        else throw new RuntimeException("otp not specified in the Configuration.properties file.");
    }
}
