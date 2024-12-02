package org.example.councurrency;

import java.util.LinkedList;

/**
 * Практическая задача - Concurrency - блокирующая очередь
 * Предположим, у вас есть пул потоков, и вы хотите реализовать блокирующую очередь для передачи задач между потоками.
 * Создайте класс BlockingQueue, который будет обеспечивать безопасное добавление и извлечение элементов между
 * производителями и потребителями в контексте пула потоков.
 *
 * Класс BlockingQueue должен содержать методы enqueue() для добавления элемента в очередь и dequeue() для извлечения элемента.
 * Если очередь пуста, dequeue() должен блокировать вызывающий поток до появления нового элемента.
 *
 * очередь должна иметь фиксированный размер.
 *
 * Используйте механизмы wait() и notify() для координации между производителями и потребителями.
 * Реализуйте метод size(), который возвращает текущий размер очереди.
 */
public class BlockingQueue<T> {
    private final LinkedList<T> queue;
    private final int limit;

    public BlockingQueue(int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == limit) {
            wait(); // Ожидание, пока не освободится место
        }
        queue.add(item);
        notifyAll(); // Уведомление ожидающих потребителей
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Ожидание, пока не появится элемент
        }
        T item = queue.removeFirst();
        notifyAll(); // Уведомление ожидающих производителей
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }

    public int capacity() {
        return limit;
    }
}

