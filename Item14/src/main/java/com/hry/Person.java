package com.hry;

/** Natural ordering for Person objects, first by lastName, then by firstName, and finally by age.
 This means that whenever Person objects need to be sorted,
 they will be ordered according to these rules unless an explicit comparator is provided. **/

public record Person(String firstName, String lastName, int age) implements Comparable<Person> {

    @Override
    public int compareTo(Person other) {
        int lastNameComparison = lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return Integer.compare(age, other.age);
    }
}