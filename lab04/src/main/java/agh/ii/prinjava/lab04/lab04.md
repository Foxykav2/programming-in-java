# Lab 4

___
#####  2) Generic methods, classes, and interfaces
___

**1)**
Generic methods allow type parameters to be used to express dependencies among the types of one or more arguments of a method and/or its return type.


**2)**
Exemple of syntax for generic class déclaration

```java
public class GenericClass<T> {
    private T data;

    public GenericClass(T data) {
        this.data = data;
    }
}
```
Exemple of syntax for generic methode déclaration
```java
public <T> T findMax(T[] array) {
    if (array == null || array.length == 0) {
        return null;
    }

    T max = array[0];
    for (T element : array) {
        if (element.compareTo(max) > 0) {
            max = element;
        }
    }

    return max;
}
```

**3)**

A raw type - a generic class or interface used without specifying a concrete type 

not safe because there is a lack of type Safety

it's allow for  enables backward compatibility with earlier versions of Java, i.e., pre-Java5

**4)**

the first result will not generate an error because we have a raw type

the seconde will generate an error because we want a integer and we gave a sting

**5)**

```java
public class Main {
    public static void main(String[] args ) {
        Integer[] ints = {1, 2, 3};
        String[] strs = {"A", "B", "C"};

        print(ints);
        print(strs);
    }

    public static void print(Object[] elems) { // <- complete this line
    for (int i = 0; i < elems.length; i++)
        System.out.print(elems[i] + " ");
    System.out.println();
    }
}   
```

___
#####  3) Bounds for type variables
___

**1)**
Ensure Type Safety,Enable Access to Specific Methods,Provide Compile-Time Information

**2)**
```java
interface Moveable {
    void goTo(double x, double y);
}

// Modify the generic function with a bound
private static <T extends Moveable> void moveAll(T[] elems, double x, double y) {
    for (var e : elems) {
        e.goTo(x, y);
    }
}
```
___
#####  4) Subtyping and Wildcards
___

**1)**

Invariance: Invariance strictly preserves type relationships, making subtype substitution impossible for generic types.


Covariance: Covariance allows you to use more specific types where base types are expected, preserving the hierarchy of types.


Contravariance: Contravariance permits you to use base types where more specific types are expected, often useful in function argument scenarios.

**2)**
A subtype wildcard (? extends T) allows reading elements from an unknown subtype of a specific type T.

A supertype wildcard (? super T) enables adding elements of type T or any of its supertypes to a collection.

An unbounded wildcard (?) offers flexibility by allowing you to work with elements of an unknown type without imposing restrictions or assumptions.

**3)**
GenBox<B> gb2 = new GenBox<C>(); - Doesn't compile because generic types are not covariant,

GenBox<B> gb3 = new GenBox same reason

gb5.setX(new B()); - Doesn't compile because you can't set an instance of B into a GenBox<? extends B> due to the wildcard being unknown and potentially more specific than B.

gb5.setX(new C()) same reson.

B b3 = gb9.getX(); - Doesn't compile because gb9.getX() may return an object of type Object due to the lower-bound wildcard, and you can't assign Object directly to B.

B b4 = gb10.getX(); - Doesn't compile because gb10.getX() returns an unknown type due to the unbounded wildcard, and you can't assign an unknown type directly to B.

