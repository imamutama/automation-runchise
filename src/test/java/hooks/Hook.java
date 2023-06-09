package hooks;

import capabilities.DriverFactoryManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before()
    public static void beforeScenario() {
        DriverFactoryManager.startDriverByMavenParameter(System.getProperty("environment"));
    }

    @After()
    public static void afterScenario() {
        DriverFactoryManager.quitDriver();
    }
}
