package org.example.councurrency.executor;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Создайте класс ComplexTaskExecutor, в котором будет использоваться
// CyclicBarrier и ExecutorService для синхронизации выполнения задач.
// Реализуйте метод executeTasks(int numberOfTasks), который создает пул потоков
// и назначает каждому потоку экземпляр сложной задачи для выполнения.
public class ComplexTaskExecutor {
    private ComplexTask task;

    public ComplexTaskExecutor(int totalParts) {
        this.task = new ComplexTask(totalParts);
    }

    public void executeTasks(int numberOfTasks) {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);
        CyclicBarrier barrier = new CyclicBarrier(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            final int part = i + 1;
            executor.submit(() -> {
                try {
                    barrier.await();
                    task.executePart(part);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
