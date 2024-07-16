## Problem:

### Eliminate obsolete object references

* Java has GC, so you can do your own business and let JVM take care of memory management 

* There is only one big BUT, We have to be aware:

  **Memory leak!**

    * Memory leak silently manifest itself as reduced performance due to increased

    * garbage collector activity or increased memory footprint.



### Source of problem:
####   1. A class manages its own memory
####   2. Caches
####   3. Listeners and other callbacks


### Solutions:

#### **1. A class manages its own memory :**
#### Null out obsolete reference
An obsolete reference is simply a reference that will never be dereferenced again.

```Java
public Object pop() {
    if (size == 0)
        throw new EmptyStackException();
    Object result = elements[--size];
    elements[size] = null; // Eliminate obsolete reference
    return result;
}
```

An added benefit of nulling out obsolete references is that if they are subsequently
dereferenced by mistake, the program will immediately fail with a **NullPointerException**,
rather than quietly doing the wrong thing.

> ⚠ Nulling out object references should be the exception rather than the norm.

##### When should you null out a reference? 
##### **_Simply put, it manages its own memory._**

whenever a class manages its own memory, the programmer should be alert for memory leaks.


#### **2. Caches :**
 Another common source of memory leaks is caches.

#### Using WeakHashMap
Entries will be removed automatically after they become obsolete.
WeakHashMap is useful only if the desired lifetime of
cache entries is determined by external references to the key, not the value.

* WeakHashMap is useful only if the desired lifetime of
  cache entries is determined by external references to the key, not the value.

the cache should occasionally be cleansed of entries that have fallen into disuse. This can be
done by a background thread (perhaps a **ScheduledThreadPoolExecutor**) or as a
side effect of adding new entries to the cache. The **LinkedHashMap** class facilitates
the latter approach with its **removeEldestEntry** method.


#### **3. Listeners and other callbacks**
One way to ensure
that callbacks are garbage collected promptly is to store only weak references to
them, for instance, by **_storing them only as keys in a WeakHashMap_**.


