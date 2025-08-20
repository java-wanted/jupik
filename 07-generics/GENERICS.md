## 7 GENERICS

### Introduction

It could be required to define a type that could keep a variable of any type.
The such variable must be declared to have the type Object. Indeed, to process
an operation specific to the actual type of this variable it must be explicitly
casted to its actual type before.

For example:

- Create a class Box that could keep a variable of any type

- Provide a test that tests that a variable kept in an instances of this class could
  be casted to its actual type and a specific operation on this type could be
  called.

It is possible to request the Java translator to try to check that a
variable of a class is assigned with instancies of a specific type,
defined when an instance of this class is declared. The such type is
called a generic type in Java.

For example:

- Create a class Box that could keep a variable of any type

- Declare this variable with a generic type defined when an instance of the class
  Box is declared.

Solve the follwoing boxing issue:

- Create a class box to keep three instances of objects, each of its own parametric
  type

- Create two instances of this class with parametric types defined to be String,
  Integer and Float in order.

- Calculate the sum of all variables of numberic types within this two boxes.

### Parametrisation

Parametrise collections created to solve the car park problem to keep arbitrary
objects:

- Parametrise interfaces CarCollection, CarList, CarSet, CarQueue and CarMap

- Parametrise their implementations in accord

### Extends and WildCard

Create a class Box with one generic parameter that:

- keeps an array of some objects

- provides a constructor that receive an arbitrary number of objects
  as arguments

- provides an operation to retrieve the mean of that objects

To calculate the mean, objects could be cast to the interface Number. If so,
the generic parameter must be restricted to types that could be casted to the
Number:

    class Box<T extends Number> {
        protected T []arrray
        ...

It is possible to restrict a type to extend a few interfaces. Use the sign
& to achieve this:

    class Box<T extends Number & Comarable<T> & Serializable> {
        ...

Now the generic type T of the class Box extends the interface Comarable
on type T. And its is possible to provide operation to compare boxes
of the same type T against the mean.

    class Box<T extends Number & Comarable<T>> {
        public int compare(Box<T> other) {
            ...

There is a problem. Let it is requred to compare boxes of different types.
If so, the wild card operator *?* must be specified instead the type T in the
operation compare:

    class Box<T extends Number & Comparable<T>> {
        public int compare(Box<?> other)
            ...

Take attention that a generic class of a type T is not an ancestor of a
generic class of a type that is successor of the type T. Thus, the following
brings a compilation error:

    ArrayList<Number> items = new ArrayList<Integer>();
    error: incompatible types: ArrayList<Integer> cannot be converted to
           ArrayList<Number>

In the such case, it must be specified that the ancestor type accepts
a type that extends some basic type:

    ArrayList<? extends Number> items = new ArrayList<Integer>();

Thus:

- It is possible to restrict a type of a generic parameter with the keyword
  *extends*

- A few interfaces separated by the sign *&* could be specified in the such
  case

- The wild card *?* could be used to specify a type that extends some
  type (the type objects if the clause *extends* is absent)

### Parameterised operations

Let it is required to provide an operation that receivece a collections of
elements of an arbitrary type and returns an element of this collections.
It is possible to parametrise this operation to return the element with
a specific type:

    <T> T getElement(Collection<T> collection) {
        ...

Solve the following transfer problem:

- Provide an operation that receive two instances of the type List, src and dst

- The operation must move all elements from the first instance to the second one

Let there is a type A and its successor type B. It is valid to assign an instance
ot the type B to a variable of the type A.

Update the operation provided to solver the transfer problem:

- It MUST BE accepted to pass any successor of a type as the src argument

- It MUST BE accepted to pass any ancestor ot a type as the dst argument

Indeed, the statements are equal. The keyword *extends* is expected. But the keyword
*super* could be used in some cases also.

    <T1 extends T2, T2> void operation(T1 a, T2 b)
    <T1> void operation(T1 a, List<? super T1> b)

Solve the following agrarian problem:

- Create a type Fruit and its successors Apple and Orange

- Provide the type Fruit with property weight, 1 for instancies of Apply and 1.5 for
  instancies of Orange

- Create a parameterised type Basket. An instance of this type for types Apple or
  Orange could keep the only instances of Apple or Orange respectively. An instance
  for the type Fuit could keep instances of both Apple and Orange. It is acceptable to
  use a collection internally.

- Provide the type Basket with the operation wieght to retrive the total weight of
  instancies of Fruit in an instance of the type Basket

- Provide the type Basket with the operation add to add a Fruit into the basket

- Provide the type Basket with the operation compare to compare two instancies of
  the type Basket of elements of any types against them weight

- Provide the type Basket with the operatioin transfer to move the all instancies of
  the type Fruit from a one instance of the type Basket to an other one. It is
  permited to move only Apples into an Apple Basket and to move only Oranges into
  an Orange Basket. But it is accepted to move any Basket into a Fruit one.

### Interview

Answer the following questions:

- What are the Java Generics?

  To answer that generics allows to provide a type as a parameter does not describe
  the matter. Parameterised types just provide some type check information for the
  Java translator. Do not rely that an object has a specific type in runtime.

- What is the usage of the keywords extends and super relative to generics?

- What is the wildcard?

- If an operation receive a collection of Numbers, is it possible to provide
  it with a collection of Integers?

  The answer that it is not possible is not complete. It is required to draw attention
  that there is no inheritance between concrete types of a parameterised type. Let it
  could be prermitted to create a refference on a collection in the such way. Then it
  must be permitted to add a Float into this concreate collection via this refference.
  But it is exactly the thing that generics are indended to prohibit if possible.

- What is a concrete type of a collection that must be specified to let it to accept
  addition of any numberic type - float, double and so on?

  It is wrong that it must extends Number. Take attention to the word any and to the fact
  that number is intended to represent values of six specific types only or some types
  that could be represented by this types in a resonable way. Actually, to accept any
  numeric type the concrete type must be Object.
