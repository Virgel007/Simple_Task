package org.example.collection;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Практическое задание - Collection - фильтрация
 * Напишите метод filter, который принимает на вход массив любого типа,
 * вторым аргументом метод должен принимать клас, реализующий интерфейс Filter,
 * в котором один метод - Object apply(Object o).
 * <p>
 * Метод должен быть реализован так чтобы возвращать новый массив,
 * к каждому элементу которого была применена функция apply
 */
public class FilterUtil {

    public static Object[] filter(Object[] array, Filter filter) {
        Object[] result = new Object[array.length];
        int count = 0;

        for (Object item : array) {
            Object applied = filter.apply(item);
            if (applied != null) { // Если функция возвращает не null, добавляем в результат
                result[count++] = applied;
            }
        }

        // Удаляем лишние элементы в массиве результата
        Object[] finalResult = (Object[]) Array.newInstance(array.getClass().getComponentType(), count);
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult;
    }
}
