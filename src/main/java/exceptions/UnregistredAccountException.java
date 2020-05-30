package exceptions;

/**
 * Исключение незарегистрированного счета
 */
public class UnregistredAccountException extends Exception {
    /**
     * Конструктор без параметров
     */
    public UnregistredAccountException(){super();}

    /**
     * Конструктор с информационным сообщением
     * @param message информационные сообщения
     */
    public UnregistredAccountException (String message){
        super(message);
    }
}

