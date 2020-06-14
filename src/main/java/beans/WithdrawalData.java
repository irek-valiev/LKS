package beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Класс для описаня операции пополнения средств
 */
@AllArgsConstructor
@Data
public class WithdrawalData {
    /**
     * Страхователь
     */
    private Policyholder policyholder;
    /**
     * Сумма
     */
    private double sum;
    /**
     * Дата/время
     */
    private Date data;
}
