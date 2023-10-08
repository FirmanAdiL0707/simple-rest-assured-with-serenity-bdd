package base;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

public class EnvironmentVariable {
    static SystemPropertiesConfiguration configuration = new SystemPropertiesConfiguration(
            SystemEnvironmentVariables.createEnvironmentVariables());
    static EnvironmentVariables env = configuration.getEnvironmentVariables();

    public static String BASE_URL = config().getProperty("baseUrl");

    static EnvironmentSpecificConfiguration config(){
        System.out.println("MASUK ENV VARIABLES");
        return EnvironmentSpecificConfiguration.from(env);
    }
}