package utilities;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class BaseTest {
    private static final EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String BASE_URL = EnvironmentSpecificConfiguration.from(env).getProperty("webdriver.base.url");
    private static final String VALID_USERNAME = EnvironmentSpecificConfiguration.from(env).getProperty("valid.username");
    private static final String VALID_PASSWORD = EnvironmentSpecificConfiguration.from(env).getProperty("valid.password");

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getValidUsername() {
        return VALID_USERNAME;
    }

    public static String getValidPassword() {
        return VALID_PASSWORD;
    }
}
