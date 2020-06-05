package exceptions;

/**
 * Исключение ошибок регистрации
 */
public class RegException extends Exception {
    /**
     * Конструктор без параметров
     */
    public RegException(){super();}

    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public RegException(String message){
        super(message);
    }

}
