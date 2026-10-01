import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigTest {

    @BeforeAll
    static void printConfig() {
        System.out.println("URL стенда: " + Config.get("stand.url"));
        System.out.println("URL API: " + Config.get("api.url"));
        System.out.println("Тайм-аут: " + Config.get("timeout"));
        System.out.println("Режим логирования: " + Config.get("logging.mode"));
        System.out.println("Стартовый товар: " + Config.get("product.name"));
        System.out.println("Цена стартового товара: " + Config.get("product.price"));
    }

    @Test
    void configReadTest() {
        String standUrl = Config.get("stand.url");
        String apiUrl = Config.get("api.url");
        int timeout = Integer.parseInt(Config.get("timeout"));
        String loggingMode = Config.get("logging.mode");

        String login = Config.get("admin.login");
        String password = Config.get("admin.password");

        String productName = Config.get("product.name");
        int productPrice = Integer.parseInt(Config.get("product.price"));

        assertEquals("http://localhost:8080/", standUrl);
        assertEquals("http://localhost:8080", apiUrl);
        assertTrue(timeout > 0);
        assertFalse(loggingMode.isEmpty());
        assertFalse(login.isEmpty());
        assertFalse(password.isEmpty());
        assertEquals("стакан", productName);
        assertEquals(13, productPrice);
    }
}
