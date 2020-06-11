package beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Класс для описаня операции переводов средств между страхователями
 */
@AllArgsConstructor
@Data
public class TransferData {
    /**
     * Страхователь-отправитель средств
     */
    private Policyholder fromPolicyholder;
    /**
     * Страхователь-получатель средств
     */
    private Policyholder toPolicyholder;
    /**
     * Сумма
     */
    private double transferSum;
    /**
     * Дата/время
     */
    private Date data;
}
