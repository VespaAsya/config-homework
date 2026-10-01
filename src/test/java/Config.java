import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = Config.class.getResourceAsStream("/config.properties");
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось прочитать config.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
