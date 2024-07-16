## Problem:

### Enforce the singleton property with a private constructor or an enum type
[Helpful article](https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
)

* A singleton is simply a class that is instantiated exactly once [Gamma95].

* Making a class a singleton can make it difficult to test its clients (impossible to substitute a mock
  implementation for a singleton)


### Two common ways to implement singletons:
Both are based on keeping the **constructor private** and exporting a **public static member** to provide
access to the sole instance.
####   1. Member is a final field
####   2. Public member is a static factory method
####   3. Single-element enum


### Implementations:

#### **1. Member is a final field :**

```Java
// Singleton with public final field
public class Elvis {
  public static final Elvis INSTANCE = new Elvis();
  private Elvis() { ... }
  public void leaveTheBuilding() { ... }
}
```
The private constructor is called only once, to initialize the public static final
field Elvis.INSTANCE.

> ⚠  **_caveat_**: a privileged client can invoke the private constructor **reflectively**
with the aid of the **AccessibleObject.setAccessible** method. If you
need to defend against this attack, modify the constructor to make it **throw an
exception** if it’s asked to create a second instance.

#### Main advantages of the public field approach :
* the API makes it clear that the class is a singleton: the public static field is final, so it will always contain
the same object reference. 
* The second advantage is that it’s simpler.


#### **2. Public member is a static factory method :**

```Java
// Singleton with static factory
public class Elvis {
  private static final Elvis INSTANCE = new Elvis();
  private Elvis() { ... }
  public static Elvis getInstance() { return INSTANCE; }
  public void leaveTheBuilding() { ... }
}
```

#### Main advantages of the static factory approach :

* It gives you the **flexibility** to change your mind about whether the class is a singleton without changing its API. 
* The factory method returns the sole instance, but it could be modified to return, say, a **separate instance for each thread** that invokes it. 
* You can write a **generic singleton** factory if your application requires it.
* A **method reference** can be used as a supplier, for example Elvis::instance is a Supplier<Elvis>.

> Unless one of these advantages is relevant, the public field approach is preferable.

### serializable
* To make a singleton class that uses either of these approaches serializable,
it is not sufficient merely to add implements **Serializable** to its declaration.
* Declare all instance fields **transient** and provide a **readResolve method**. Otherwise, each time a
serialized instance is deserialized, a new instance will be created.

```java
// readResolve method to preserve singleton property
private Object readResolve() {
// Return the one true Elvis and let the garbage collector
// take care of the Elvis impersonator.
return INSTANCE;
}
```
#### **3. Single-element enum :**
A third way to implement a singleton is to declare a single-element enum:

```JAVA

// Enum singleton - the preferred approach
public enum Elvis {
INSTANCE;
public void leaveTheBuilding() { ... }
}
```

* This approach is similar to the public field approach, but it is more **concise**.
* Provides the **serialization** machinery for free
* Provides an ironclad guarantee against **multiple instantiation**, even in the face of sophisticated serialization or
_reflection attacks_.

> **Note** : you can’t use this approach if your singleton must extend a superclass other than Enum
(though you can declare an enum to implement interfaces).

