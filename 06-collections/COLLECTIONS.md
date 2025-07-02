## COLLECTIONS

### ArrayList

There are a few collections in the Java Standard Library: ArrayList, LinkedList,
HashMap, LinkedHashSet, TreeMap, TreeSet and so on. To be hired for a position
of a Junior Plus Java Programmer it is REQURED to know how they are implemented.

No doubt, the only way is to look the text of an implementation. But it is assumed
in this course that to write some parodies on them is not completely meaningless
also.

Create a system of registration for a car park:

- Retrive the information about a car with its index

- Register a new car into a list of cars

- Remove a specific car from the list with the car on hand

  The operation MUST return True if the car has been removed successfully or
  False otherwise.

- Remove a specific car from the list with its index

  The operation MUST return True on succe3ss or False if the removal failed also.

- Retrive the number of cars registered

- Remove all cars from the list

Also, if there is no an index in the list the exception *IndexOutOfBoundException*
MUST be thrown out.

There is a conception of the Clean Architecture, so called tern SOLID. A one of
conception is that systems MUST BE desined at the level of its abstraction not
at the level of its implementation.

For this case it means that an interface MUST BE used to declare a list of cars.

There is a conception of the Test Drive Development, TDD. It means that the tests
MUST BE written before an implementation.
