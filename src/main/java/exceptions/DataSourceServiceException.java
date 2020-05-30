package exceptions;

/**
 * Исключение при подключении к БД
 */
public class DataSourceServiceException extends Exception{
    /**
     * Конструктор без параметров
     */
    public DataSourceServiceException() {super();}

    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public DataSourceServiceException (String message){
        super(message);
    }
}
