package exceptions;

public class AuthException extends Exception {
    /**
     * Конструктор без параметров
     */
    public AuthException(){
        super();
    }
    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public AuthException(String message){
        super(message);
    }
}
