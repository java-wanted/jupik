## 4 Advanced Java

### Exceptions

There is exception handling in Java:

- It is possible to pass an instance of a special class to JVM to notify
  it about some condition. It is called to throwgh an exception

- It is possible to process the such instance in the upper level operations
  with the operator try-catch

Solve the follwoing issue:

- Provide an operation that throws IndexOutOfBoundsException

- Process this exception in an upper level logic

### String and Random

In Java to represent an object as a string the operation *toString* could be
used. The default implementation of this operation is provided by the class
Object the class all classes are inherited from.

There is an operation *format* of the class String. This operation could be
used to create a string from the first argument, a string containing format
modifiers, with modifiers substituted from other arguments.

There is a class Random. An instance of this class could be used to
get pseudo random nambers.

Solve the following issue:

- Print a random number in the range from 5 to 10 inclusive
