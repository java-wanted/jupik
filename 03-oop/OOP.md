## 3 OOP

### Introduction to OOP

Object Oriented Programming, OOP, is a programming that is oriented to
objects. In Java OPP is based on conceptions of classes and objects.

A class is a pattern an object is build around. For example an abstract
dog could be described

- by presence of tail, paws and fur
- by ability to bark, to eat and to run

An object presents an instance of a class. For example a dog Toozik could
be described by the facts that it is a dog that

- it is small, has brown fur, four paws, short tail
- and its age is three

An other examples of a class and an object of this class:

- A car is a vehicle that consists of four wheels, an engine and could move
  itself.

- There is a car of the kind Nisan, red coloured, produced in 2010.

In Java class is defined by

- its name

- its fields

- its operations, *methods* in Java

So, to be simple, a class in Java is just an ADT.

A Logistic Issue:

- Create a class Box that keeps the height, length and width of a box.

- Instantiate two boxes and calculate they volumes.

Reference types:

    - A variable of the type of a class does not keeps the class. Instead, it
      refera to an instance of the class if assigned. To create an instance of
      a class the operator new MUST BE used.

    - If variable of a some type refere to an instance the such type is called
      a reference type in Java. A few variables of a reference type could refer
      to the same instance of this class.
