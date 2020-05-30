package beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Класс для описания страхователя
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Policyholder implements Organization {

    /**
     * Идентификатор
     */
    private int id;
    /**
     * Логин
     */
    private String login;
    /**
     * Пароль
     */
    private String psswd;
    /**
     * Наименование организации
     */
    private String nameOfCompany;
    /**
     * ИНН
     */
    private String inn;
    /**
     * Имя руководителя
     */
    private String director;
    /**
     * Счет
     */
    private Account account;

    /**
     * Конструктор
     * @param id идентификатор
     * @param nameOfCompany наименование организации
     * @param inn ИНН
     * @param director Имя руководителя
     */
    public Policyholder(int id, String nameOfCompany, String inn, String director, Account account){
        this.id = id;
        this.nameOfCompany = nameOfCompany;
        this.inn = inn;
        this.director = director;
        this.account = account;
    }

    /**
     * Конструктор
     * @param login логин
     * @param psswd пароль
     * @param nameOfCompany наименование организации
     * @param inn ИНН
     * @param director Имя руководителя
     */
    public Policyholder(String login, String psswd, String nameOfCompany, String inn, String director, Account account){
        this.login = login;
        this.psswd = psswd;
        this.nameOfCompany = nameOfCompany;
        this.inn = inn;
        this.director = director;
        this.account = account;
    }

    /**
     * Сеттер списка счетов
     *
     * @param account список счетов
     */
    public void setAccount (Account account){
        this.account = account;
    }

    /**
     * Геттер полного имени
     *
     * @return полное имя
     */
    public String getFullName(){
        return String.join(" | ", nameOfCompany, inn, director);
    }

}
