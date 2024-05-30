## Problem:

### large numbers of optional parameters

## Solutions:
### 1. Telescoping Constructor pattern:

   The telescoping constructor pattern works, but it is hard to write client code when there are many parameters, and harder still to read it.

  
  _If the client accidentally reverses two such parameters! ... (the compiler
   won’t complain)_

### 2.  JavaBeans pattern:
1. Call a parameterless constructor to create the object
2. Call setter methods to set each required parameter and each optional parameter of interest
       

   _allows inconsistency, mandates mutability_

Because construction is split across multiple calls, a JavaBean may be in an **_inconsistent_** state partway through its construction.

the JavaBeans pattern precludes the possibility of making a class _**immutable**_ (Item 17) and _requires added effort_ on the part of the programmer to ensure **_thread safety_**.


### 3.  [Builder pattern](https://refactoring.guru/design-patterns/builder):

1. Call a constructor (or static factory) with all the required parameters and gets a builder object. 
2. Call setter-like methods on the builder object to set each optional parameter of interest.
3. Calls a parameterless build method to generate the object, which is typically **immutable**.
   
* To detect invalid parameters as soon as possible, check parameter validity in the builder’s constructor and methods.


#### The Builder pattern is well suited to class hierarchies. 

* Abstract classes have abstract builders; concrete classes have concrete builders. 