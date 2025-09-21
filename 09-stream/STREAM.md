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
