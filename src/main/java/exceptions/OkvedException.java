package exceptions;

public class OkvedException  extends Exception {
    /**
     * Конструктор без параметров
     */
    public OkvedException(){super();}

    /**
     * Конструктор с информационным сообщением
     * @param message информационные сообщения
     */
    public OkvedException (String message){
        super(message);
    }
}

