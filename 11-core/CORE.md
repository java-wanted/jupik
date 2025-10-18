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
