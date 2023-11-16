# Lab 6

___
#####   Functional interfaces, lambda expressions and method references
___

**1)**
Functional Interface:

A functional interface in Java is an interface with a single abstract method, serving as a foundation for lambda expressions.

Lambda Expression:

A lambda expression in Java is a concise way to represent anonymous functions, simplifying the syntax for implementing functional interfaces.


Method Reference:

Method reference in Java provides a shorter and clearer syntax for using existing methods as implementations of functional interfaces, enhancing code readability.



**2)**
```java 
// Lambda expression for f1(x) = x - 2
Function<Double, Double> f1 = x -> x - 2;

double result1 = f1.apply(5.0);
System.out.println("f1(5.0) = " + result1);
```
```java
// Lambda expression for f2(x, y) = sqrt(x^2 + y^2)
BiFunction<Double, Double, Double> f2 = (x, y) -> Math.sqrt(x * x + y * y);

double result2 = f2.apply(3.0, 4.0);
System.out.println("f2(3.0, 4.0) = " + result2);
```
**3)**
Square Root :

```java

Function<Double, Double> sqrt = Math::sqrt;

double sqrtResult = sqrt.apply(25.0);
System.out.println("Square Root of 25.0: " + sqrtResult);
```

Absolute Value :

```java

Function<Double, Double> abs = Math::abs;

double absResult = abs.apply(-10.5);
System.out.println("Absolute Value of -10.5: " + absResult);
```

Logarithm :

```java


Function<Double, Double> log = Math::log;

double logResult = log.apply(2.0);
System.out.println("Natural Logarithm of 2.0: " + logResult);
```
Identity Function :

```java

Function<Double, Double> id = Function.identity();

double idResult = id.apply(42.0);
System.out.println("Identity Function of 42.0: " + idResult);
```

**4)**
```java 
FunIf<String, Integer> f1 = s -> s.length(); 
FunIf<Integer, String> f2 = i -> String.valueOf(i); 
FunIf<Double, Double> f3 = d -> d * 2; 
FunIf<Integer, Boolean> f4 = n -> n % 2 == 0; 
FunIf<Boolean, Integer> f5 = b -> b ? 1 : 0; 
FunIf<Boolean, Boolean> f6 = b -> !b;
```

___
#####   Standard functional interfaces
___

**3)**
it aim to enhance performance by avoiding autoboxing and unboxing overhead associated with generic types, while also providing more readable and expressive code for operations on primitive data types.

___
#####   Higher-order functions
___

**1)**
```java
import java.util.stream.IntStream;

public class SumExample {
    public static void main(String[] args) {
        int result = IntStream.rangeClosed(1, 15)
                .sumOfWith(i -> Math.pow(i, 5));
        System.out.println("Sum: " + result);
    }
}
```

**3)**
```java
import java.util.function.DoubleUnaryOperator;

public class DerivativeApproximation {
    public static void main(String[] args) {
        DoubleUnaryOperator f = x -> x * x; 
        double x0 = 2.0;
        double h = 0.001;

        DoubleUnaryOperator derivative = dfr(f, h);
        
        double result = derivative.applyAsDouble(x0);
        System.out.println("Approximation of f'(" + x0 + "): " + result);
    }

    static DoubleUnaryOperator dfr(DoubleUnaryOperator f, double h) {
        return x -> (f.applyAsDouble(x + h) - f.applyAsDouble(x)) / h;
    }
}
```
___
#####   Function composition
___

**1)**
*a*)

```java
import java.util.function.Function;

public class FunctionCompositionExample {
public static void main(String[] args) {
Function<Double, Double> f1 = x -> 2 * x;

        Function<Double, Double> g1 = x -> x * x;
        
        Function<Double, Double> composition1 = f1.compose(g1);
        
        double result1 = composition1.apply(3.0); // (2 * (3^2)) = 18.0
        System.out.println("(f1 ∘ g1)(3.0) = " + result1);
    }
}
```
*B*

```java
import java.util.function.Function;

public class FunctionCompositionExample {
    public static void main(String[] args) {
        // Function f2(x) = sin(x)
        Function<Double, Double> f2 = Math::sin;

        // Function g2(x) = (1 - x) / (1 + x^2)
        Function<Double, Double> g2 = x -> (1 - x) / (1 + x * x);

        // Composition (f2 ∘ g2)(x)
        Function<Double, Double> composition2 = f2.compose(g2);

        // Test the composition
        double result2 = composition2.apply(0.5); // sin((1 - 0.5) / (1 + 0.5^2)) ≈ 0.6829
        System.out.println("(f2 ∘ g2)(0.5) = " + result2);
    }
}
```

___
#####   Dealing with optional data
___

**2)**
Throwing an Exception:

Pros: Explicitly signals exceptional conditions, forces handling.
Cons: Performance overhead, code clutter.
Returning null:

Pros: Simple indication of no result, no exception handling.
Cons: Null checks required, potential for NullPointerException, semantics ambiguity.
Using Optional:

Pros: Expressive, avoids null checks, no null references.
Cons: Additional object overhead, learning curve for teams unfamiliar with Optional.

