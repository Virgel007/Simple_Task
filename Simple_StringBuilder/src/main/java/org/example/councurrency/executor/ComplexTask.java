package org.example.councurrency.executor;

// * Создайте класс ComplexTask, представляющий сложную задачу, которую несколько потоков будут выполнять.
// * В каждой задаче реализуйте метод execute(), который выполняет часть сложной задачи.
public class ComplexTask {
    private int totalParts;
    private int completedParts;
    private boolean isCompleted;

    public ComplexTask(int totalParts) {
        this.totalParts = totalParts;
        this.completedParts = 0;
        this.isCompleted = false;
    }

    public synchronized void executePart(int part) {
        if (part <= totalParts && !isCompleted) {
            System.out.println("Executing part " + part + " of the complex task");
            completedParts++;
            if (completedParts == totalParts) {
                isCompleted = true;
                System.out.println("Complex task completed");
            }
        } else {
            System.out.println("Invalid part number or task already completed");
        }
    }

    public synchronized boolean isCompleted() {
        return isCompleted;
    }
}
