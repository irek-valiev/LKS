package exceptions;

/**
 * Исключение вывода средств со счета некорректной суммой
 */
public class WithdrawalException extends Exception {

    public WithdrawalException (String message){
        super(message);
    }
}
