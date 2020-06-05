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
     *Страница упешного завершения проводимой денежной операции
     */
    SUCCESS_TRANSACTION_PAGE("/views/successTransaction.jsp"),

    /**
     * Страница профиля
     */
    PROFILE_PAGE("/views/profile.jsp"),

    /**
     * Страница с ошибкой операций со счетом
     */
    ERROR_PAGE("/views/error.jsp"),

    /**
     * Страница ошибки при регистрации с пустыми полями
     */
    ERROR_EMPTY_REG("/views/error_empty_reg.jsp"),
    /**
     * Страница ошибки при попытке авторизоваться с пустыми полями
     */
    ERROR_EMPTY_AUTH("/views/error_empty_auth.jsp"),

    /**
     * Страница с ошибкой при регистрации
     */
    ERROR_REG_PAGE("/views/error_reg.jsp");

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
