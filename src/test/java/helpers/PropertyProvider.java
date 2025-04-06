package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertyProvider {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = PropertyProvider.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не найден файл конфигурации: config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки конфигурационного файла", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getAdditionalNumber() {
        return Integer.parseInt(properties.getProperty("entity.additional_number"));
    }

    public static List<Integer> getImportantNumbers() {
        return Arrays.stream(properties.getProperty("entity.important_numbers").split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
