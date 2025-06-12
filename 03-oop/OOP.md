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

Solve the following demographics issue:

    - Create a class to describe humans with a name, an age and a weight.

    - Create three instancies of humans and assign all its properties with
      arbitrary values.

    - Print the mean age of this humans.

### Introduction to methods

There are so called *methods* in Java. A *method* is just an operation
on an ADT.

Solve the following issue:

- Create a class Dog to describe the name, the kind and the weight of a dog.

- Provide an operation that returns a string representation of the all
  information provided in an instance of the class Dog.

- Create an instance of the class Dog and use this operation to output the
  information onto a terminal.

If an operatioin is not intended to return a value its return type could be
marked with the type void.

Solve the following issue:

- Extend a class Dog with the property speed of type int and an operation
  run.

- The operation run MUST output the word "Run" the number of times equals
  the value of the property speed.

### Parameters

In Java *methods* cold be provided with parameters.

In an operations, properties and operations of a class could be refered
with the keyword *this*. For example:

    class A
        field
        op(field)
            this.field = field

An example:

- To extend the class Box with an operation to configure values
  of fields.

Solve the follwoing issue:

- Create a class to keep the properties length and width of an rectangle.

- Provide an operation to set this properties.

- Provide an operation to calculate the area of the rectangle.

### Initialisation of objects

There are special operations to initialise ojects, so called *constructors*.
A contructor is called on the operator new. Iff no constructor is declared
a default one is provided by the Java translator.

Solve the following HRM problem:

- Create a class to keep properties of an employee: a name, a position and
  salary.

- Provide a constructor to initialise this properties.

- Provide an operation to print the all information about a such employee
  onto a terminal.

### Overloading

It is possible to assign the same name for a few operations of a class. If so,
a translator selects a one by parameters it is called with. The such property
is called *overloading* in Java.

In Java, to call a constructor from an other constructor the keywork this could
be used:

        this(parameters...)

Solve the following frightening issue:

- Create a class to keep properties of a monster: the number of eyes, hands and
  legs.

- Provide constructors to assign properties:

    - a one without parameters to assign all properties with the number two

    - a one with the only one parameter to be assigned to all properties

    - a one that requires to specify values for each property

- Provide an operation *voice*:

    - it MUST output the string *Grrrr...* if called without parameters

    - it MUST output the same string a specific number of times if called with
      an integer parameter *count*

    - it MUST output a specific string a specific number of times if called with
      integer and string parameters *count* and *word* in order.


### Objects like parameters

It is possible to pass reference types as paramters or the return value of
operations.

Solve the following issue:

- Extend the class Box with an operation to compare an instance against an other
  one by the volume.

- The operation MUST return -1, 0 or 1 if the volume of the instance is lesser,
  equal or greater that the volume of the other instance.

Solve the following issue:

- Extend the class Box with an operation to return a copy of an instance.

Solve the follwoing issue:

- Extend the class Box with an operation to return a Box with all dimensions
  doubled.

### Access Modifiers

There are access modifiers in Java: public, private, protected and package
private. The modifiers define the scope a class and its properties could be
accessed from.

The keywork private prevents to access a property of a class outside of
operations of this class.

It is NOT REQUIRED to set a property to be private in Java. Ask some Java
translator if worry. But it could be valuable to mark:

- a property is out of attention of a user of a class

- there is a constraint to modify a property

There are name spaces in Java. They are called packages.

If a class or its property has no access modifier it has the package private
modifier by default. And Java prevents to access the such entiry from an
other package.

Solve the following issue:

- Rewrite the class Box to use access modifiers.

- The all fields MUST BE private.

- It MUST BE possible to access the operations of the class from other packages.
