package org.example;

import org.example.collection.FilterImpl;
import org.example.collection.FilterUtil;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("Hello ");
        sb.append("World!");
        System.out.println(sb.toString());

        sb.undo();
        System.out.println(sb.toString());

        sb.append("Всем привет ");
        sb.append("как дела, ");
        sb.append("Мир просто супер");
        System.out.println(sb.toString());

        sb.delete(5, 10);
        System.out.println(sb.toString());

        sb.insert(5, "!");
        System.out.println(sb.toString());

        MyLocalDateTime myLocalDateTime = new MyLocalDateTime(LocalDateTime.now());
        System.out.println(myLocalDateTime.getLocalDateTime());

        FilterUtil filterUtil = new FilterUtil();

        // Integer array filtering
        Integer[] intArray = {1, 2, 3};
        Integer[] filteredInts = (Integer[]) filterUtil.filter(intArray, new FilterImpl());
        System.out.println("Filtered Integers: " + Arrays.toString(filteredInts));

        // String array filtering
        String[] strArray = {"one", "two", "three"};
        String[] filteredStrings = (String[]) filterUtil.filter(strArray, new FilterImpl());
        System.out.println("Filtered Strings: " + Arrays.toString(filteredStrings));

        // Double array filtering
        Double[] doubleArray = {1.1, 2.2, 3.3};
        Double[] filteredDoubles = (Double[]) filterUtil.filter(doubleArray, new FilterImpl());
        System.out.println("Filtered Doubles: " + Arrays.toString(filteredDoubles));
    }
}