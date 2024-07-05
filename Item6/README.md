## Problem:

### Creating unnecessary objects

#### Reuse a single object instead of creating a new functionally equivalent object each time!
#### An object can always be reused if it is immutable.
#### In addition to reusing immutable objects, you can also reuse mutable objects if you know they won’t be modified

## Solutions:

### 1.  String :
        String s = new String("bikini"); // DON'T DO THIS!
        String s = "bikini"; // DO THIS!

While String.matches is the easiest way to check if a string matches
a regular expression, it’s not suitable for repeated use in performance-critical
situations.

### 2. Using static factory methods

_The factory method Boolean.valueOf(String) is preferable to the constructor Boolean(String)._

The constructor must create a new object each time it’s called, 
while the factory method is never required to do so and won’t in practice.

### 3. Adapter Design pattern:

there’s no need to create more than one instance of a given adapter to a given object.

### 4. Autoboxing
* To detect invalid parameters as soon as possible, check parameter validity in the builder’s constructor and methods.


#### The Builder pattern is well suited to class hierarchies.

* Abstract classes have abstract builders; concrete classes have concrete builders. 