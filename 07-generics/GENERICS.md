## 7 GENERICS

### Introduction

It could be required to define a type that could keep a variable of any type.
The such variable must be declared to have the type Object. Indeed, to process
an operation specific to the actual type of this variable it must be explicitly
casted to its actual type before.

For example:

- Create a class Box that could keep a variable of any type

- Provide a test that tests that a variable kept in an instances of this class could
  be casted to its actual type and a specific operation on this type could be
  called.
