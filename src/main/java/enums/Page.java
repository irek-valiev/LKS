package enums;

/**
 * Перечисление, содержащие страницы для навигации
 */
public enum Page {

    /**
     * Главная страница
     */
    INDEX_PAGE("/index.jsp"),

    /**
     * Страница регистрации
     */
    REG_PAGE("/auth/registration.jsp"),

    /**
     * Страница успешной регистрации
     */
    SUCCESS_REG_PAGE("/views/successRegPolicyholder.jsp"),

    /**
     * Страница аутентификации
     */
    AUTH_PAGE("/auth/auth.jsp"),

    /**
     * Страница успешной аутентификации
     */
    SUCCESS_AUTH_PAGE("/views/successAuthPolicyholder.jsp"),

    /**
     * Страница профиля
     */
    PROFILE_PAGE("/views/profile.jsp"),

    /**
     * Страница с ошибкой
     */
    ERROR_PAGE("/views/error.jsp");

    /**
     * Поле страница
     */
    private String page;

    /**
     * Конструктор с полем названия страницы
     * @param page название страницы
     */
    Page(String page){
        this.page = page;
    }

    /**
     * Геттер названия страницы
     * @return адрес страницы
     */
    public String getPage(){
        return page;
    }
}
