package com.hry;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ashly", "Taylor",35);
        Person p2 = new Person("Harry", "Watson", 19);
        Person p3 = new Person("Bob", "Jackson", 25);

        /*List<Person> list = Arrays.asList(p1, p2, p3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);*/

        Set<Person> ts = new TreeSet<>();
        ts.add(p1);
        ts.add(p2);
        ts.add(p3);
        System.out.println(ts);

    }
}
