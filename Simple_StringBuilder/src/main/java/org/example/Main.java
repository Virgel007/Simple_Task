package org.example;

import org.example.collection.CountOfElements;
import org.example.collection.FilterImpl;
import org.example.collection.FilterUtil;
import org.example.councurrency.BlockingQueue;
import org.example.javacore.MyLocalDateTime;
import org.example.javacore.MyStringBuilder;

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

        CountOfElements countOfElements = new CountOfElements();
        String[] strArray2 = {"one", "two", "three", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "four", "five", "six", "seven", "ten", "eleven", "twelve", "eleven", "twelve"};
        System.out.println("Count of elements in array: " + countOfElements.countOfElements(strArray2));

        BlockingQueue<Integer> queue = new BlockingQueue<>(4);
        System.out.println("Capacity of queue: " + queue.capacity());
        System.out.println("Size of queue: " + queue.size());

        Thread thread1 = new Thread(() -> {
            try {
                queue.enqueue(1);
                queue.enqueue(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                queue.enqueue(3);
                queue.enqueue(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("First element in queue: " + queue.dequeue());
                System.out.println("Size of queue after dequeue: " + queue.size());
                System.out.println("Second element in queue: " + queue.dequeue());
                System.out.println("Size of queue after dequeue: " + queue.size());
                System.out.println("Third element in queue: " + queue.dequeue());
                System.out.println("Size of queue after dequeue: " + queue.size());
                System.out.println("Fourth element in queue: " + queue.dequeue());
                System.out.println("Size of queue after dequeue: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}