package exceptions;

public class ChekTaxException extends Exception {
    /**
     * Конструктор без параметров
     */
    public ChekTaxException() {super();}
    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public ChekTaxException (String message){super(message);}


}
