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
