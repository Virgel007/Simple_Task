package org.example.councurrency.executor;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                    task.execute(part);
                    barrier.await();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
