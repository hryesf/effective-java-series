## Problem:

### Classes were not designed to be instantiated!
### What are those classes?(utility class)
##### A class that is just a grouping of static methods and static fields.
#### 1. They can be used to group related methods on primitive values or arrays (like java.lang.Math or java.util.Arrays)
#### 2. They can also be used to group static methods, including factories.
#### 3. for objects that implement some interface (like java.util.Collections)
#### 4. Classes can be used to group methods on a final class, since you can’t put them in a subclass.

**Such utility classes were _not designed to be instantiated_.**

## Solutions:
### 1. Attempting to enforce noninstantiability by making a class abstract:
problems:
1. The class can be subclassed and the subclass instantiated.
2. It misleads the user into thinking the class was designed for **_inheritance_**.

### 2. A class can be made noninstantiable by including a **private constructor**:
1. Because the explicit constructor is private, it is inaccessible outside the class.
* _As a side effect this idiom also prevents the class from being subclassed_.
