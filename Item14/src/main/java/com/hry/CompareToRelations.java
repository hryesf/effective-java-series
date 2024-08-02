package com.hry;

public class CompareToRelations {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", "Jackson", 25);
        Person p2 = new Person("Alice", "Jackson", 25);
        Person p3 = new Person("Charlie", "Taylor",35);

        // Checking reflexivity
        System.out.println(p1.compareTo(p1) == 0); // true: p1 should be equal to itself

        // Checking symmetry
        System.out.println(p1.compareTo(p2) == 0); // true: p1 is considered equal to p2 in terms of age
        System.out.println(p2.compareTo(p1) == 0); // true: p2 is considered equal to p1 in terms of age, demonstrating symmetry

        // Checking transitivity
        System.out.println(p1.compareTo(p2) <= 0); // true: p1 is younger than p2
        System.out.println(p2.compareTo(p3) <= 0); // true: p2 is younger than p3
        System.out.println(p1.compareTo(p3) <= 0); // true: p1 is younger than p3, demonstrating transitivity

    }
}