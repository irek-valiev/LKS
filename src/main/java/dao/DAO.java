package dao;

import beans.Okved;
import exceptions.ChekTaxException;
import exceptions.OkvedException;
import exceptions.RegException;
import exceptions.UnregistredPolicyholderException;

import java.util.List;

/**
 * Обобщенный интерфейс для получения объекта из БД
 *
 * @param <T> обобщенный тип
 */

public interface DAO<T> {
    /**
     * Метод вставки информации в БД
     *
     * @param t обобщенный тип
     */
    void insert(T t) throws UnregistredPolicyholderException, RegException, ChekTaxException;

    void insert();

    default T get (String firstParam) throws Exception{
        return null;
    }

    /**
     * Метод получения информации из БД по 2 параметрам
     *
     * @param firstParam  первый параметр
     * @param secondParam второй параметр
     * @return обобщенный тип объекта
     * @throws Exception ошибка при получении объекта из БД
     */
    default T get (String firstParam, String secondParam) throws Exception{
        return  null;
    }

    /**
     *
     * @return
     */
    default List<T> getAll(){
        return null;
    };
    /**
     *
     * @param t
     */
    default void update(T t){
        //NOP
    }

    default T getById (int id) throws Exception{
        return null;
    }

    Okved getOkved(String kod_okved) throws OkvedException;
}
