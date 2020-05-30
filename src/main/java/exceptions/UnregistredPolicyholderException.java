package exceptions;

/**
 * Исключение незарегистрированного страхователя
 */
public class UnregistredPolicyholderException extends Exception {

    /**
     * Конструктор без параметров
     */
    public UnregistredPolicyholderException(){super();}

    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public UnregistredPolicyholderException(String message){
        super(message);
    }
}
