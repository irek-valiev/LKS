package dao;

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
    void insert(T t);

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

}
