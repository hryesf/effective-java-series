package com.hry;


// automatic conversion that the Java compiler makes
// between the primitive types and their corresponding object wrapper classes.
// Autoboxing can lead to unnecessary object creation
// Each time a primitive type is converted to its wrapper class, a new object may be created.

public class AutoboxingExample {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long sum = sumWithAutoboxing();
        long endTime = System.nanoTime();
        System.out.println("Sum with autoboxing: " + sum);
        System.out.println("Time taken with autoboxing: " + (endTime - startTime) + " ns");
    }

    public static long sumWithAutoboxing() {
        Long sum = 0L; // Long object, not long primitive
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            sum += i; // Autoboxing happens here
        }
        return sum;
    }
}
