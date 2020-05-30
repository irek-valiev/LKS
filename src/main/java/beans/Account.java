package beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для описания объекта "Счет"
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Account {
    /**
     * Идентификатор
     */
    private int id;
    /**
     * Номер счета
     */
    private int accountNumber;
    /**
     * Сумма на счете
     */
    private int sum;

    /**
     * Конструктор счета по его номеру
     * @param accountNumber номер счета
     */
    public Account(int accountNumber){
        this.accountNumber = accountNumber;
    }
    /**
     * Переопределнный метод equals
     * @param object объект
     * @return флаг равенства
     */
    @Override
    public boolean equals(Object object){
        Account account = (Account) object;
        return this.accountNumber == account.getAccountNumber();
    }
    /**
     * Переопределенный метод вывода класса счета в строку
     * @return номер счета и сумму на нём через разделитель
     */
    @Override
    public String toString(){
        return String.join(" | ", String.valueOf(accountNumber), String.valueOf(sum));
    }

}
