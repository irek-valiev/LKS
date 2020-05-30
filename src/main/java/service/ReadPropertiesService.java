package service;

import exceptions.PropertyReaderException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс для считывания информации из property-файлов
 */
@Slf4j
public class ReadPropertiesService {
    /**
     * Название файла для считывания информации о БД
     */
    private static final String DATA_SOURCE_PROPERTY_PATH = "datasource.properties";

    /**
     * Метод считывания файла с данными о БД
     * @return набор данных о БД
     * @throws PropertyReaderException ошибка считывания файла с данными
     */
    public static Properties readDataSourceProperty() throws PropertyReaderException{
        try (InputStream inputStream = ReadPropertiesService.class.getClassLoader().getResourceAsStream(DATA_SOURCE_PROPERTY_PATH)){
            log.info(String.join(" ", "считывание файла", DATA_SOURCE_PROPERTY_PATH));
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        }catch (IOException e){
            log.error(String.join(" ", "Ошибка во время считывания файла: ", DATA_SOURCE_PROPERTY_PATH), e);
            throw new PropertyReaderException(String.join(" ", "Ошибка во время считывания файла: ", DATA_SOURCE_PROPERTY_PATH));
        }
    }
}
