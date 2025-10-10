## 9 STREAM API

### Lambda Expressions

There is anonymous operations in Java.

Consider the following logic:

    new Thread(new Runnable(){
        public void run()
        {
            ...
        }
    }

Here, an instance of Thread is created providing an instance of an anonymous
class as the argument.

The interface Runnable is a functional interface - it declares one and only one
non-default operation. Also, such an interface could be decorated with an
informative decorator, FunctionalInterface.

In such a case, the logic of the only operation of the anonymous class could be
provided in the form of an anonymous operations, or lambda expression:

    new Thread(
        () -> {
            ...
        }
    );

Here, the brackets means the empty list of arguments of the run operation and the
right arrow digraf refers the body of the operation.

Solve the following HRM anonymous issue:

- Provide a interface Worker with the only work operation.

- Provide a class Director, with an operations that call the work operation of
  an instance of Worker, provided as an argument.

- Create an instance of Director and let her to make work two workers. A one provided
  as an anonymous class and an other one provided as a lambda expression.

Operations that accepts parameters and return a value could be written in the form
of anonymous expressions also. The types of arguments are known for the translator
and could be skipped:

    interface I
    {
        public R f(A1 a1, A2 a2));
    }
    I i = (a1, a2) -> {
        ...
    }
    R r = i(x1, x2);

Update the operation work of the Worker interface to receive the number of times
the work MUST BE worked and to return the result.

Let there is a collection of integers. Let it is required to provide an operation
that accepts such a collection and a predicate and returns a collection of only
numbers that satisfy this predicate.

To declare such predicate in anonymous form, the Predicate interface can be used.
This interface defines an operation of boolean type that accepts an argument.

Solve the problem above, using an anonymous operation to get even numbers only.

### Filter and map and collect

To process elements of collections, the collection could be represented as a
sequence of its elements. Such a sequence is called a stream in Java.

With such streams it is possible:

- to filter some elements of the stream out

- to replace elements of the stream in accord with some mapping

- to put elements of the resulting stream into a collection

The operations on streams belongs to two kinds:

- intermediate operations, that defines how to process each elements

- terminal operations, that perform processing and yield the result

Solve the following root evaluation problem:

- Create a collection of one thousand of random integers, from 100 to 200

- Leave only the integers that are divisible by five without a remainder

- Replace integers with their square roots, the double type

- Replace square roots with strings "sroot:SQUARE\_ROOT"

- Put the result strings into a list

### Intermediate and Terminal Operations

The operations of Stream that do not return a stream are terminal operations.

Let there is a type User with properties name and age. Print number of users
with the age above 35 years. If so, the count operation could be used on
the stream filtered by the age.

The operation of Stream that return a stream are intermediate operation.

Print three oldest users. If so, the limit operation could be used on the
stream ordered by the age with the sorted operator.

Solve the following user replace problem:

- Let there are users, meaning the name and age properties

- Order users by their names in the acceding order lexically

- Leave only the users that are older 40 years

- Leave only the first three of hers

- Replace users with her names

- Print the resulting strings onto the terminal

### Create Stream Operations

There are stream operations that return an instance of the type Optional. This
type allows to process a case when no elements have been provided to the operation.

Use the type Optional to solve the lexicographic HRM problem:

- Print out the information about the first user her name contains a letter "l"

- If there is no such user, report about it.

There are ways to create a Stream:

- Use the stream operation of a Java Collection

- Use the static operation stream of the type Arrays

- Use static operations of the type Stream

There is the parrallelStream operation of the type Stream. This operation
perform processing of elements of the stream in parallel, on a few tasks.

Solve the following float stream problem:

- Create a collection of float numbers, from zero to 3 millions

- Use the stream operation to convert the collection to a stream

- Update values in accord with the following formula:

    f: v -> sin(0.2f + v / 5) + cos(0.2f + v / 5) + cos(0.4f + v / 2)

- Convert the resulting stream into a collection

- Print the time taken by the calculation

- Use the parralelStream operation to process the origin collection in the
  same way

- Print the time taken by the calculation in parallel

### Interview about Streams

The following questions MUST BE answered to be hired on a position of a high
society Java Plus Plus Junior Programmer:

- What is a functional interface?

- What does the stream operation do?

- Why it can be required to transform a collection into a stream.

  It is not bad to notice that the streams allows to separate a transform as a
  set of operations from the way this operations are performed.

- What do methods exist to create streams?

- What are the differences of the terminal and intermediate operators?

  Probably, it is not bad just to say that intermediate operators specifies some
  rules to transform elements. And the terminal operation defines how to process
  elements in accord with this rules and how to represent the result.

- Provide examples of terminal and intermediate operators.

- What does the map operator intended for?

- What is the type Options? How does it relate to streams?

- How does the filter operator work?

  Formally, it is wrong to answer that the operator process elements. Answer that it
  adds rules to exclude some elements from further processing.

- There is a sorted operator. How will the sorting be done if this operation will be
  called on a stream of elements of a custom type?

  Actually, it is answered how to provide an operation to compare elements.
