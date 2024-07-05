package com.hry;

public class StringExample {
    public static void main(String[] args) {

        stringCreation();

    }

    private static void stringCreation() {
        // 4 ways to create a string in Java:

        String s1 = new String("Bob");

        // String s1 = new String("Bob").intern();
        // "Bob" string literal ==> string pool
        // s1 = new String() ==> new String created and "Bob" copied into string pool
        // (no ref and the object would be collected by GC)
        // s1.intern() ==> makes s1 point to "Bob" string literal

        //String s1 = "Bob";

        //String s1 = String.valueOf("Bob"); // always prefer static factory - lazy


        String s2 = new String("Bob");
        System.out.println(s1 == s2); // false ==> if s1 and s2 pointing to different references
        System.out.println(s1.equals(s2)); // content wise comparison
    }

    // Performance can be greatly improved!
    static boolean isRomanNumeral(String s) {
        // creates a Pattern instance for the regular expression
        // uses it only once
        // after, it becomes eligible for garbage collection.
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}