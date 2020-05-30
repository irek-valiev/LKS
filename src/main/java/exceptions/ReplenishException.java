package exceptions;

/**
 * Исключение пополнения счета некорректной суммой
 */
public class ReplenishException extends Exception {


    /**
     * Конструктор без параметров
     */
    public ReplenishException(){
        super();}

    /**
     * Конструктор с информационным сообщением
     * @param message информационное сообщение
     */
    public ReplenishException(String message){
        super(message);
    }
}
