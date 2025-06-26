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

Solve the following play dev issue:

- Model one hundred of a dice roll

- To model a roll

    - Get a pseudo random number from 1 to 6 inclusive

    - Print this number in the format

        The number is NUMBER.

- To print the number the operation format MUST BE used

### Multi-threading

There is multi-threading in Java.

To run a thread of execution the class Thread MUST BE used. There is a
construction of of this class that accepts an instance of the interface
Runnable. If so, the operation run of the instance of the interfce will be
executed on a dedicated thread when the operation start of the instance of
the class Thread will be called.

Solve the follwoing play dev issue:

- Store a random number from 0 to 1 milliard

- Create a thread that will generate random numbers until a one equals the
  number stored above is generated

- Create an other thread to print numbers from 0 with step 1 every second
  until the thread above do not stop to generate numbers
