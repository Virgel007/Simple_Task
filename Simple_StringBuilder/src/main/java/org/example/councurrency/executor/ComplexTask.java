package org.example.councurrency.executor;

public class ComplexTask {
    private int totalParts;

    public ComplexTask(int totalParts) {
        this.totalParts = totalParts;
    }

    public void execute(int part) {
        if (part <= totalParts) {
            System.out.println("Executing part " + part + " of the complex task");
            for (int i = 0; i < 1000000000; i++) { // Simulate some work
                if (i % 10000000 == 0) {
                    System.out.println("Part " + part + " is " + i + "% complete");
                }
            }
        } else {
            System.out.println("Invalid part number");
        }
    }
}