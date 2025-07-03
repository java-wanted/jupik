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

### ArrayList 2

Extend operations of the list of cars from the topic above with a new operation
add:

- The operation MUST accept a car and an index parameters and insert the car
  to be placed into the list at the given index

- Tests against insertions into the middle, head and tail MUST BE provided

There is a conception of time complexity of an algorithm. For example:

- The notation *O(1)* means that the time of an operation does not depend
  on the size of data to be processed

- The notation *O(n)* means that the time of an operation is in linear
  dependence of the size of data

The time complexity of operation of an array:

- To get an element by index - *O(1)*

- To add an element into an array or to remove it from - *O(n)*

  But for implementations that multiplies the capacily of the array if no free space
  left it is *O(log n)* in average.
