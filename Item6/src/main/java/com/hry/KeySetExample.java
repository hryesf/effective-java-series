package com.hry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetExample {
    public static void main(String[] args) {
        // Create a Map and add some entries
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Get the keySet view
        Set<String> keySet1 = map.keySet();
        System.out.println("KeySet1: " + keySet1); // [one, two, three]

        // Get another keySet view
        Set<String> keySet2 = map.keySet();
        System.out.println("KeySet2: " + keySet2); // [one, two, three]

        // Check if both keySet views are the same object
        System.out.println("Are keySet1 and keySet2 the same object? " + (keySet1 == keySet2)); // true

        // Modify the map
        map.put("four", 4);
        System.out.println("KeySet1 after modifying map: " + keySet1); // [one, two, three, four]
        System.out.println("KeySet2 after modifying map: " + keySet2); // [one, two, three, four]

        // Remove an entry using one of the keySet views
        keySet1.remove("one");
        System.out.println("Map after removing 'one' using keySet1: " + map); // {two=2, three=3, four=4}
        System.out.println("KeySet2 after removing 'one' using keySet1: " + keySet2); // [two, three, four]
    }
}
