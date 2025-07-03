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

### LinkedList

A linked list keeps data on nodes where the list refers to the first
node and each node refers to the next one:

- To retrive the i-th node from the current one move to the next node
  i times.

- To add an element after a specific position of a list create a new
  node, refer it to the nodes after the position and update the reference
  of the node at the position to refer the new node.

In double linked lists each node refers to the previous one also.

Solve the following car park issue:

- Provide a class LinkedCarList to implement the interface CarList on
  a doubly linked list.

### Interview about List

There are ArrayList and LinkedList in Java Standard Library.

Answer the following questiong:

- What is the difference between ArrayList and LinkedList?

  The answer that ArrayList could be based on an array and LinkedList could
  be based on a linked structure seams to be reasonable.

- What is the time complexity to retrive an element by index for ArrayList
  and for LinkedList?

  The answer that it is O(1) for the former and O(n) for the later seams to be
  reasonable. Although, the way the elements of a list are arranged internally
  is implementation and architecture dependent.

- What is the time complexity to remove an element by index for ArrayList
  and for LinkedList?

  The answer that it is O(n) for the formaer and O(1) for the later seams to be
  wrong. Indeed, the term index assume random access not a serial one.

- What are cases when it is reasonable to use LinkedList instead of ArrayList?

  The answer that it has sence when it is expected to insert elements into the head
  or into the middle of the list or remove them frequently seams to be naive. Actually,
  to use an array is required if it has relatively small size or the random access is
  strongly required.

- What problems could happen if huge ammount of elements are inserted and removed
  from ArrayList for a significant time?

  The answer that ArrayList could hold a great ammount of memory seams to be not
  appropriate. Certainly, there must be strong requirements to use an array in the
  such conditions that some redundancy does not matter. In either case, ArrayList
  provides operation to release resource if not used.
