package processors;

import beans.Account;
import exceptions.ReplenishException;
import exceptions.WithdrawalException;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс, содержащий операции над счетами
 */
@Slf4j
public class AccountProcessor {

    private static void validateReplenishSum(int replenishSum) throws ReplenishException{
        log.info("Валидация суммы пополнения счета");
        if(replenishSum <= 0){
            log.error("Ошибка при пополнении - сумма пополнения меньше или равна нулю");
            throw new ReplenishException("Сумма пополнения счета меньше или равна нулю");
        }
    }

    /**
     * Метод пополнения счета
     * @param account      счет
     * @param replenishSum сумма пополнения
     * @return флаг пополнения счета
     */
    public static synchronized void replenishAccount(Account account, int replenishSum) throws ReplenishException{
        log.info(String.join(" ", "Пополнеие счета", String.valueOf(account.getAccountNumber()), "на сумму ", String.valueOf(replenishSum)));
        validateReplenishSum(replenishSum);
        account.setSum(account.getSum() + replenishSum);
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()), "прошло успешно. Текущая сумма на счете", String.valueOf(account.getSum())));
    }

    private static boolean validateWithdrawalSum(int accountSum, int withdrawalSum) throws WithdrawalException{
        log.info("Валидация суммы списания со счета");
        if(withdrawalSum <= 0){
            log.error("Ошибка при списании - сумма списания меньше или равна нулю");
            throw new WithdrawalException("Сумма списания меньше или равна нулю");
        } else if(accountSum < withdrawalSum){
            log.error("Ошибка при списании - сумма списания больше суммы на счете");
            throw new WithdrawalException("сумма списания больше суммы на счете");
        }
        return true;
    }

    /**
     * Метод списания со счета
     * @param account
     * @param withdrawaslSum
     * @throws WithdrawalException
     */
    public static void withdrawalAccount(Account account, int withdrawaslSum) throws WithdrawalException{
        log.info(String.join(" ", "Списание со счета", String.valueOf(account.getAccountNumber()), "на сумму", String.valueOf(withdrawaslSum)));
        validateWithdrawalSum(account.getSum(), withdrawaslSum);
        account.setSum(account.getSum() - withdrawaslSum);
        log.info(String.join(" ", "Списание со счета", String.valueOf(account.getAccountNumber()), "прошло успешно. Текущая сумма на счете", String.valueOf(account.getSum())));
    }

    /**
     * Метод перевода средств
     * @param fromAccount
     * @param toAccount
     * @param transferSum
     * @throws WithdrawalException
     * @throws ReplenishException
     */
    public static void transferMoney(Account fromAccount, Account toAccount, int transferSum) throws WithdrawalException, ReplenishException{
        log.info(String.join(" ", "Перевод средств со счета",
                String.valueOf(fromAccount.getAccountNumber()), "на счет",
                String.valueOf(toAccount.getAccountNumber()), "на сумму", String.valueOf(transferSum)));
        withdrawalAccount(fromAccount, transferSum);
        replenishAccount(toAccount, transferSum);
        log.info(String.join(" ", "Перевод средств со счета",
                String.valueOf(fromAccount.getAccountNumber()), "на счет",
                String.valueOf(toAccount.getAccountNumber()), "на сумму", String.valueOf(transferSum), "прошел успешно"));
    }
}

