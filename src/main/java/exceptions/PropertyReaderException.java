package exceptions;
/**
 * Исключение считывание данных из property-файлов
 */
public class PropertyReaderException extends Exception {
    /**
     * Конструктор без параметров
     */
    public PropertyReaderException(){
        super();
    }

    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public PropertyReaderException(String message){
        super(message);
    }
}
