# Lab 5

___
#####  List >E< and its two implementations: ArrayList>E<, LinkedList>E<
___

**1)** The second loop will run faster because the first one traverse the list at the beginning, so in worst case we need to parkour all the list
the second one is getting straigh to the point.

**2)** it will be [1,2,4,5]

**3)** indew out of Bond because the list is change during the loop

**4)**  Code 2 is likely to work as expected due to the use of a List type, whereas Code 1 may result in an IndexOutOfBoundsException.

___
##### 3) Iterators, the for-each loop (aka. enhanced for loop), and forEach method
___

**1)**
while loop
```java 
List<Integer> lst = List.of(1, 2, 3, 4, 5);
Iterator<Integer> iterator = lst.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
```
for loop
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
Iterator<Integer> iterator = lst.iterator();
for (; iterator.hasNext();) {
    System.out.println(iterator.next());
}
```
enhanced for-loop
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
for (int num : lst) {
    System.out.println(num);
}
```
forEach loop
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
lst.forEach(num -> System.out.println(num));
```
___
##### 4) Queue>E<, Deque>E< and their implementations: PriorityQueue>E<, and ArrayDeque>E<
___

**2)** the first loop will create a list but not order, the second delete yhe somallest number each time, so it will print the liste in assended order


___
##### 5) java.lang.Comparable and java.util.Comparator
___

**2)**
```java
static Object max(Comparable o1, Comparable o2) {
    if (o1.compareTo(o2) >= 0) {
        return o1;
    } else {
        return o2;
    }
}
```

**3)**
```java
private static void m() {
    String[] cities = {"Copenhagen", "Warsaw", "Budapest"};
    Arrays.sort(cities, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
    System.out.println(Arrays.toString(cities));
}
```

___
##### 6) Set>E< and its implementations: HashSet>E<, LinkedHashSet>E<, TreeSet>E<, and EnumSet<E extends Enum>E>>
___

**1)**  HashSet for fast retrieval without caring about order, LinkedHashSet to maintain insertion order, TreeSet for sorted elements, and EnumSet when working with enum types efficiently. 

**2)**
union:

```java
Set<T> set1 = ...; 
Set<T> set2 = ...; 

Set<T> union = new HashSet<>(set1);
union.addAll(set2);
```

intersection:

```java
Set<T> set1 = ...; 
Set<T> set2 = ...; 

set1.retainAll(set2);
```

difference:

```java
Set<T> set1 = ...; 
Set<T> set2 = ...; 

set1.removeAll(set2);
```

**3)**
```java
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static TreeSet<String> transformToUppercase(TreeSet<String> inputSet) {
        TreeSet<String> result = new TreeSet<>();
        
        for (String str : inputSet) {
            result.add(str.toUpperCase());
        }
        
        return result;
    }

    public static void main(String[] args) {
        TreeSet<String> originalSet = new TreeSet<>();
        originalSet.add("apple");
        originalSet.add("banana");
        originalSet.add("cherry");

        TreeSet<String> uppercaseSet = transformToUppercase(originalSet);

        System.out.println("Original Set: " + originalSet);
        System.out.println("Uppercase Set: " + uppercaseSet);
    }
}
```

___
##### 7) Map<K,V> and its implementations: HashMap<K,V>, LinkedHashMap<K,V>, TreeMap<K,V>, and EnumMap<K extends Enum<K.>,V>
___

**1)** HashMap use for fast access to key-value pairs and don't require any specific order.


 LinkedHashMap use for predictable iteration order (insertion-order or access-order) and may be building an LRU cache.

 TreeMap use for keys to be ordered in a specific way or want to perform range-based operations.

EnumMap usz when keys are enum constants and you want an efficient storage and retrieval mechanism.


**2)**

___
##### 8)Selected algorithms from java.util.Collections and java.util.Arrays
___

**2)**

binary search relies on the property of sorted data to efficiently narrow down the search space by dividing it into two halves at each step. Without sorted data, this division and the associated speed advantages are not possible, making binary search less effective or even unusable.

**3)**

the main difference in terms of time complexity is that binary search, with a time complexity of O(log n), is more efficient than linear search, which has a time complexity of O(n), 



