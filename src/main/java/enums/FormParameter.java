package enums;

/**
 * Перечисление, содержащие параметры из форм страниц
 */
public enum FormParameter {
    /**
     * Параметр для входа в систему
     */
    ENTER_PARAMETER("enter"),

    /**
     * Параметр для регистрации в системе
     */
    REG_PARAMETER("reg");

    /**
     * Параметр из формы
     */
    private String formParameter;

    /**
     * Конструктор с параметром из формы
     * @param formParameter параметр из формы
     */
    FormParameter (String formParameter){
        this.formParameter = formParameter;
    }

    /**
     * Геттер параметра из формы
     * @return параметр из формы
     */
    public String getFormParameter(){
        return formParameter;
    }
}
