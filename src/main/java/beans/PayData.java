package beans;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Класс для описаня операции перечисления страховых взносов
 */
@AllArgsConstructor
@Data
public class PayData {
    /**
     * Страхователь
     */
    private Policyholder policyholder;
    /**
     * Целевой счет
     */
    private String targetAccount;
    /**
     * Сумма
     */
    private int sum;
    /**
     * Дата/время
     */
    private Date data;
}
