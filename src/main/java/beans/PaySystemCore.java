package beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Класс для описания ядра платежной системы
 */

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor

public class PaySystemCore {
    private List<Account> paySystemAccounts;
    private List<Organization> paySystemPolicyholders;
    private Map<Policyholder, List<Account>> paySystemPolicyholderAccounts;

    /**
     * Метод инициализации клиентов и их счетов
     */
    private void initPolicyholderAccounts(){
        //TODO реализовать метод инициализации полной информации клиент-счета платежной системы
    }

    /**
     * Метод вывода всех счетов ядра платежной системы
     */
    public void showAllAccounts(){
        System.out.println("Список всех счетов:");
        for(Account account : paySystemAccounts) {
            System.out.println(account.toString());
        }
        System.out.println();
    }

    /**
     * Метод отображения всех клиентов
     */
    public void showAllPolicyholders(){
        //TODO написать метод вывода всех клиентов,
        // переопределив в классе Client метод toString для отображения ФИО и списка счетов клиента.
    }

}
