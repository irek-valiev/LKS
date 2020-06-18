package beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для описаня объекта ОКВЭД
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Okved {
    /**
     * Идентификатор
     */
    private int okvedId;
    /**
     * Код вида экономической деятельности
     */
    private String kod_okved;
    /**
     * Расшифровка вида экономической деятельности
     */
    private String nameVed;
    /**
     * Класс профессионального риска
     */
    private int riskClass;
    /**
     * Страховой тариф
     */
    private double rate;

    /**
     * Конструктор ОКВЭДа по его коду
     * @param kod_okved номер счета
     */
    public Okved (String kod_okved){
        this.kod_okved = kod_okved;
    }
    /**
     * Переопределнный метод equals
     * @param object объект
     * @return флаг равенства
     */
    @Override
    public boolean equals(Object object){
        Okved okved = (Okved) object;
        return this.kod_okved == okved.getKod_okved();
    }
    /**
     * Переопределенный метод вывода класса ОКВЭД в строку
     * @return код ВЭД, класс риска и страховой тариф
     */
    public String toString(){
        return String.join(" | ", String.valueOf(kod_okved), String.valueOf(riskClass), String.valueOf(rate));
    }

}
