package processors;

import beans.ChekTax;
import beans.Okved;
import exceptions.ChekTaxException;
import exceptions.ReplenishException;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс, содержащий операции над тарифом
 */
@Slf4j
public class TaxProcessor {
    /**
     * Метод расчета суммы страховых взносов
     * @param okved
     * @param FOT ФОТ за месяц
     * @return флаг расчета страховых взносов
     */
    public static synchronized double tax (Okved okved, double FOT) throws ChekTaxException{
        log.info(String.join(" ", "Расчет суммы страховых взносов из ФОТ в сумме", String.valueOf(FOT), "рублей"));
        validateFOT(FOT);
        return (FOT * okved.getRate())/100;
    }

    private static void validateFOT(double FOT) throws ChekTaxException {
        log.info("Валидация ФОТ за месяц при расчете суммы страховых взносов");
        if(FOT <= 0){
            log.error("Ошибка при расчете суммы страховых взносов - ФОТ за месяц меньше или равен нулю");
            throw new ChekTaxException("ФОТ за месяц меньше или равен нулю");
        }
    }
}
