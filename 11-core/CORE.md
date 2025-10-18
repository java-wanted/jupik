## 11 Java Core

### How Java works

Every program is a set of instruction for some device. Computers
can perform only instruction provided in the form a machine code,
sequences of binary data. It is not funny to code in a machine code.
So, programs are written in format languages, e.g. in Java.

There are translators that translate a program written in Java into
a code of a Java machine, so called byte-code:

    X.java -> javac -> X.class

There are interpreters that can perform byte-code on devices, called
Java Virtual Machines, JVMs. There are Java standard libraries also.

A JVM machine and a standard library form a Java Runtime Environment,
JRE. A set of a translator, JRE and some utilities form a Java Development
Kit, JDK.

### Interfaces and abstract classes

A Java interfaces defines operations. They allow to declare default and
static operations and static properties also:

    interface I
    {
        public static int f1 = ...;
        public static int o1(int a1) {...}
        public default int opi1(int a1) {...}
    }

An interface is an agreement on the behaviour of an object. It defines what an
object can do, not how an object does it. The possibility to declare default
operations has been added for backward compatibility only.

Controversially, abstract classes allows to declare some part of logic that
implements some behaviour.

### Exceptions and finalise

There are Runtime exceptions, unchecked exceptions. Java translator allows not
to catch them in a program. If thrown, such exceptions mean logic errors in the
program.

Other exceptions, checked exceptions, MUST BE caught with try catch statements.
All exceptions are inherited from the type Exceptions.

There is also the type Error. If thrown, it means some system errors, outside of
the responsibility of a Java program, e.g. OutOfMemoryError.

Types Exception and Error are inherited from the Throwable type.

There is the finalise operation of the Object type. This operation is called by
JVM before an instance is destroyed by the garbage collector. It is considered
to be incorrect to rely on this operation due the fact that it is unpredictable
when the garbage collector are going to destroy an object.

### OOP paradigms

Consider the following questions:

- What is OOP?

  It is a way to view a program as an hierarchy of data and their relationship.
  If so, a set of operations relates to a specific element of this hierarchy,
  an object, and allows to modify it.

- What are the basic paradigms of OOP?

  These are encapsulation, inheritance and polymorphism.

  Encapsulation means that the only behaviour of an object as described by
  its operations are taken into account to interact with it.

  Inheritance means that the behaviour of an object is inherited from its
  successors within the hierarchy and possibly extends it.

  Polymorphism means that the behaviour of successors of an objects are similar
  in some way.

### Final Interview

It is REQUIRED to answer the following interview questions to be hired for a
position of a high society Junior Java Plus Plus Programmer and start to receive
a salary of a half hundred of thousand of Russian rubles at least:

- List the main paradigms of OOP

- What is polymorphism? Provide an example.

- What is overloading of operations?

- Is it possible to create create two operations with equal name and different
  return type?

- What is the difference of static properties and operations and non static ones?

- Is it possible to access a non static attribute of a class from a static
  operation and to access a static attribute of a class from a non static
  operation?

  It is wrong that it is not possible to access a non static property from a
  static operation. A common example is a static operations that allocates an
  object and then configures its fields.

  Of course, one can argue that a non static member of a class is not a member
  of the class, but it is a member of a copy of it. But take attention that the
  term *the static member of the class* means that it is a member of the class
  by definition.

- What access modifiers do you know? What is the difference between them?

  In Java, it is wrong to answer that public means that the operation can be access
  from any point of the program. Similarly, it is wrong that package private means
  that the operation can be accessed from the package and can not be accessed outside
  of it. And it is wrong that protected means accessibility from successors of the type.
  Take into account nested classes and public interfaces.

- What is the difference between abstract classes and interfaces?

- Describe the hierarchy of collections in Java Collection Framework

- What is the difference between LinkedList and ArrayList?

- When should LinkedList be used? And when should ArrayList be used?

- What is the difference of collections List and Set?

- What are equals and hashCode operations and for what are they used for?

- What are the rules for equals and hashCode operations?

- How HashMap is organised?

- How are collisions resolved in HashMap?

- What is the time complexity of insertion an element at the head of the list
  for ArrayList and LinkedList?

- What are generics?

- What is the wildcard?

- Is it possible to terminate a task after it has been started? If so, what are
  ways to achieve it?

- What does happen after the interrupt operation is called? Way this way to
  terminate a task is safer?

- What does the join operation do?

- What methods to synchronise operations do you know?

- What is the synchronisation object when the synchronised keyword is specified in
  the definition of an operation?

- What are daemon tasks?

- What does the wait operation do?

- What do the notify and notifyAll operations?

- For what is ExecutorService for?

- What is the difference between the submit and execute operations of ExecutorService?

- What is the difference between the Runnable and Callable interfaces?

- For what is the volatile keyword for? When should it be used?

- What does the stream operation?

- For what should it be required to convert a collection into a stream of data?

- What is the difference between the terminal and transient operations?

- What does the map operation do?

- What is serialisation and de-serialisation?

- What conditions must be satisfied to serialise an instance of a type?

- For what is the transient keyword for?

- Which types allows to increase performance of reading and writing into a file by
  using buffers?
