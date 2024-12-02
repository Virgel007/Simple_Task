package org.example.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Практическое задание - Collection - count of elements
 * Напишите метод, который получает на вход массив элементов и возвращает
 * Map ключи в котором - элементы, а значения - сколько раз встретился этот элемент
 */
public class CountOfElements {

    public Map<Object, Integer> countOfElements(Object[] array) {
        Map<Object, Integer> map = new HashMap<>();
        for (Object item : array) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }
}
