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
    SUCCESS_REG_PAGE("/views/core/successRegPolicyholder.jsp"),
    /**
     * Страница аутентификации
     */
    AUTH_PAGE("/auth/auth.jsp"),
    /**
     * Страница успешной аутентификации
     */
    SUCCESS_AUTH_PAGE("/views/core/successAuthPolicyholder.jsp"),
    /**
     *Страница упешного завершения проводимой денежной операции
     */
    SUCCESS_TRANSACTION_PAGE("/views/core/successTransaction.jsp"),
    /**
     * Страница профиля
     */
    PROFILE_PAGE("/views/core/profile.jsp"),
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
     * Страница ошибки при попытке авторизоваться с неверными логином и/или паролем
     */
    ERROR_AUTH_PAGE("/views/error_auth.jsp"),
    /**
     * Страница нехватки средств на счету
     */
    NOT_ENOUGH_MONEY("/views/core/notEnoughMoney.jsp"),
    /**
     * Страница ошибки при nullе
     */
    ERROR_NULL_PAGE("/views/error_null_page"),
    /**
     * Инфостраница для фильтра при потыке пройти внутрь системы без авторизации
     */
    ERROR_NOSESSION_PAGE("/views/error_nosession_page.jsp"),
    /**
     * Страница с ошибкой при регистрации
     */
    ERROR_REG_PAGE("/views/error_reg.jsp"),
    /**
     *Проверочная страница
     */
    CHEK_PAGE("/views/chek.jsp");
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
