package enums;

/**
 * Перечисление, содержащее свойства подключения к БД
 */
public enum DbProperty {
    /**
     * Название драйвера БД
     */
    DRIVER_NAME_PROPERTY_NAME("driver_name"),
    /**
     * Адрес БД
     */
    URL_PROPERTY_NAME("url"),
    /**
     * Пользователь для подключения
     */
    USER_PROPERTY_NAME("user"),
    /**
     * Пароль для подключения
     */
    PSSWD_PROPERTY_NAME("password");

    /**
     * Поле свойства
     */
    private String property;

    /**
     * Конструктор с полем названия свойства
     * @param property название свойства
     */
    DbProperty(String property){
        this.property = property;
    }

    /**
     * Геттер названия свойства
     * @return название свойства
     */
    public String getProperty(){
        return property;
    }

}
