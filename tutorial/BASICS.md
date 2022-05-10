# Necessary information before starting to code

## Variables
A variable is a container for data. You can create a variable in Java by utilizing what's known as a statement.
You can think of a statement as an operation. Defining a variable will typically look like one of the following statements.
```java
boolean unassignedPrimitive; // false
// a single equals sign (=) is called the "assignment" operator
int assignedPrimitive = 12345; // 12345
double doubleNumber = getSomeValue();
Object value; // null
// We "assigned" "otherValue" the result of "new Object()"
Object otherValue = new Object(); // an instance of "Object"
```

## Primitives
Primitives are fairly straight forward to explain. You can think of primitive types as numbers. There's a little more
than a handful of different types. The following table will show the most important versions of them

|  Type   | Range                                           | Description                                              |
|:-------:|-------------------------------------------------|----------------------------------------------------------|
| boolean | `0` to `1`                                      | Represents true or false                                 |
|   int   | `-2147483648` to `2147483647`                   | A typical number 32-bit                                  |
| double  | `4.9E-324` to `1.7976931348623157E308`          | A large floating point (allows fractional values) number |

> There's a few more to mention, those being `byte`, `char`, `short`, `long`, and `float`, but they're used less often,
> and you typically only need to worry about the three types mentioned in the table for storing the result of a predicate
> (true/false), storing a number, and storing a number with decimal places respectively.

## Objects
Objects are a more complex type to talk about. To (attempt to) put it simply they are grouping of
data (primitives and/or objects), known as fields, and
functions to utilize that data, known as methods.

Objects are constructed into what's called an instance, which is just a specific created object.
Variable's whose type are some object actually contain what's known as a reference to a created object.
Any object variable can contain it's default value `null`.
You can think of `null` as the absence of a value. 

