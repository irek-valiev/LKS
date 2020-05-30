package beans;

/**
 * Интерфейс персона
 */

public interface Organization {
    /**
     * Метод для получения полного имени
     * @return
     */
    String getFullName();

    /**
     * Сеттер счетов
     * @param account
     */
    void setAccount(Account account);
}
