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

### Keywords static and final and arguments varargs

The keywords static allows to not provide an operation with an instance of its
class.

The keywords final if relates to a field prohibits to modify this field after it
has been initialised.

It is possible to define an operation to accept a variable number of parameters
of the same type. The parameters will be packed into an array by the translator.
For example:

    func(type... name)
        for i = 0; i < name.length; ++i
            print name[i]

    func(1, 2)

### Custom collection

In Java collection is a set of elements of the same type.

There are issues:

- List items, for example to output them onto a terminal.

- Add or remove an item from the set of existing ones.

Solve the follwoing collection issue:

- Create a list of items of a reference type

- There MUST the the following operations on the collection

    - *add(item)* - add an item to be the last element of the list

    - *remove(item)* - remove the first item if exists in the list

    - *remove(index)* - remove an item at the index index

    - *size()* - returns the number of items in the list

    - *get(index)* - get the reference on the item in the collection

- The data of the collection MUST BE kept in a Java array

    - Initially, the capacity of the underlaying array MUST BE 10

    - If there is no free array element to add an item, the capacity
      of the underlaying array MUST BE doubled

Use the list created above to sole the following HRM issue:

- Let there is a list of employees.

- Dissmis a one employee and hire an other one.

### Wrapper types

In Java there are reference types for the primitive ones. The such types are
called wrapper types. For example, there is a wrapper type *Integer* for the
type *int*.

Such wrappers provides operations to process variables of primitive types.
For example, the operation *Integer.parseInt*.

Solve the following demographic issue:

- There is an information about a human in the format:

        'This is NAME. He|She is AGE years old.'

- Extract the values for the NAME and AGE

- Create an instance of a class to represent this information

### Usual collections

There are preexisting collections of elements in Java. This collections could
be provided with a type of the elements. But the only reference types are
accepted.

Use a one to solve the followin issue:

- Create a collection that contains five arbitrary names

- Create a collection that contains five arbitrary integers

- Create a collection where the i-th elements combines the i-th name
  and i-th integer of the collections above as a string in the format

        NUMBER '-' NAME

### Inheritance

The inheritance means that some properties of a class could be provided from
some generic class.

For example, let there are some generic properties of a family of cats: fur,
legs, tail and the ability to hunter. But a particular member of this family
could have some specific properties also. For example, a cat vulgaris could
has the ability to drink whiskys.

A class that provides generic properties for some other classes is called a
super class. Classes that inherits some properties of a super class are called
sub classes.

The modificator protected could be used to accept the access to a property
from sub classes outside the package of the super class. And the modificator
private could be used to prevent a property to be accessed from sub classes
within this package.

Take attention, if no constructor of the super class is called explicitly, the
default constructor one is always authomatically in Java.

Take attention, if a property if marked to be protected, it could be accessed
from the whole package the class belongs to.

Solve the following gastronomic issue:

- Create a class to reprersent generic properties fo members of the family
  Felidae: the number of eyes, legs and the ablitily to eat humans.
- Create a two subclasses of this class, a class of domestic cats and a class
  of lions. The former has no ability to eat humans and the later has it.

### Inheritance. Overriding

It is possible to override an operation of a super class in a sub class. To call
the operation of a super class from a sub class the keyword super could be used.

Solve the following gastronomic issue:

- Update the classes that provide properties fo Felidae with an operation eat.

- The generic version of this operation MUST print the message

        'It is eating a food'

- For Domestic Cat and Lion the operation MUST BE specialised to point that they
  are eating a cap of wiskeys and a peace of a GNU relatively.

Solve the following logistics issue:

- There is a class Box with properties height, length and width

- Provide a class that extends it with the property weight

- Provide an operation to print the all properties onto a terminal

### Inheritance. Abstract operations

Solve the following geometrics issue:

- Create a class Shape with two properties: a and b, the length of sides.
  Provide a constructor to configure this properties

- Provide an operation to get the perimeter of this shapes.

- Create classes to represent triangles and rectangles. The former has
  the third parameter, c, the length of the third side.

In Java, if it is requested to prohibited creation of instances of a class,
the such class could be defined with the modifier *abstract*. Some operations of
an abstract class could be declared with this modifier also. If so, non-abstract
sublasses of this class MUST define such operations.

In Java, if a class is defined with the modifier final, it is prohibited to
create instances of this class. Overloading of an operation in sub-classes could be
prohitined with this modifier also.

### Interfaces

An instance could be casted to the type of a super class of its class implicitly.
It is called *up-cast* in Java. If an instance of the type of a super class is
casted to a sub-class it is called *down-cast*.

There are so called interfaces in Java. This types declare a set of operations
that must be implemented in a class.

Java does not support intehitance from a few classes. But a class could implement
an arbitrary number of interfaces.

Sole the following delivering issue:

- Create an interface Worker with the operation work

- Create classes that implements this interfce: Director, Coder, Cook

- Create an interface Driver with the operation driver. Implement this
  interface for classes Director and Coder.

- Create instances of the classes above. Place them into collections of those
  who could work and those who could drive.

### Interfaces and Anonymous classes

In Java it is possible to implement an interface in the only point the instance
of the such class is created:

    new INTERFACE() {
        ; implementation
    }

The such class has no name assigned explicitly and is called an anonymous class
in Java.

Solve the following serivce issue:

- Create an interface Waiter with the only operation bring. This operation
  receives the name of a dish a waiter MUST bring.

- Create a class Diner with the operation order. This operation receives
  an instance of the Waiter and the name of dish the waiter MUST BE bring in.

- Let a diner to order two dishes:

    - A one MUST BE ordered from a Waiter implemented by a class.

    - An other one MUST BE ordered from a Waiter implemented by an anonymous
      class.
