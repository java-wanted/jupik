## 8 MULTITHREADING

### Introduction

Once upon a time, it was invented to perform several tasks simultaneously. It
has been called multitasking.

If several tasks share some resources and are executed as a single process, it
is called multithreading.

There are two ways to create tasks in Java:

- Create a class that extends the class Thread

  Provide logic in the operation *run* and run this logic by calling the
  operation *start*.

- Create a class that implements the interface Runnable

  Provide logic in the operation *run*, create an instance of the class Thread
  passing the created class to its constructor and call the operation *start* of
  this instance.

Create an application that:

- prints the word *Start*

- prints integral numbers from 0 to 1000 one line on a dedicated task

- prints the word *Finish*

### Stopping tasks

There are two operation to interrupt execution of a task, *stop* and
*interrupt*:

- The former terminates a task immediately, without given it a chance to free
  up resources, so it is deprecated and should not be used.

- The later just set the attribute *interrupted*. It is responsibility of the
  task to check this flag and complete execution.

Solve the following issue:

- Update the previous application to stop printing numbers.

To wait for completion of a task, the operation *join* cold be used.

Solve the following issue:

- Create three collections of integers.

- Fill each of them with number from 0 to 1000000 in a dedicated task.

- Check the size of collections.

When several tasks are started with the operation *start* sequentially, the order
the tasks will be start is not determined.

Solve the following issue:

- Create three tasks, each one prints a specific number

- Serialise tasks to print numbers one, two and three in order

There is a way to check the time of execution of some logic. Get the current time,
the operation *currentTimeMillis* before and after execution of this logic and
check the number of milliseconds elapsed.

Solve the following issue:

- Create an array of 10 millions float number and fill it with ones initially

- Provide an operation to assign elements of an array with values calculated by
  the formula:

        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5f + i / 5f) *
                 Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f))

- Call the operation on the array and print the number of millisecond elapsed to
  calculate elements.

- Provide an operation to calculate elements with values in parallel:

  - Split the array into two parts. The operation *arraycopy* MUST BE used to
    copy elements of the array to parts.

  - Evaluate elements of parts on two tasks in accord with the formula above.

  - Copy the result of calculation into the origin array. The operation
    *arraycopy* MUST BE used also.

- Call this operation and print the time elapsed. Compare it against the time
  taken to calculate elements on a single task.

### Service tasks

It is possible to mark tasks to be service tasks:

    task.setDaemon(true)

If so, such a task are aborted after all not service tasks terminated.

Extend the application that calculates elements of arrays with a service tasks:

- The service task MUST print the next integer number starting with zero, a one
  per second until other tasks are running.

There are race conditions in Java:

- Provide a type with an attribute *count*.

- Increment the attribute one thousand times, then decrement it the same number
  of times.

- Validate the result value is zero.

- Update counting to increment the attribute on a one thread and to decrement it
  on an other one.

### Synchronisation

In Java, it is possible to mark some operations of a type with the keyword
*synchronised*. Only a one task could execute a one of such operations at a
time. A task will be stopped until it could be such a task.

    class A {
        synchronized op1() { BLOCK1 }
        synchronized op2() { BLOCK2 }
    }

There is the conception of monitors. A monitor is an object that has two states,
either acquired or released. If released, only a one task cold hold it at a time,
others will be stopped until the monitor will be released.

A block of logic that MUST BE executed by only a one task at a time is called a
critical section. A monitor allows to ensure such a way of execution.

In Java, an instance of any object could be used as a monitor. To achieve it,
a statement *synchronised* could be used.

    class A {
        Object monitor = new Object();
        op1() { ... synchronised(monitor) { BLOCK1 } ... }
        op2() { ... syncthonised(monitor) { BLOCK2 } ... }
    }

If an operation of a type is defined with the keyword *synchronised*, the
instance of the type, *this*, is used as a monitor.

There are questions that MUST BE answered to be hired on a position of Java Plus
Junior programmer:

- What is the difference between synchronised and not synchronised operations?

  To answer that a synchronised operation could be called by a one task only is
  not correct. Actually, the number of tasks that could request to acquire a
  monitor is not limited.

- What is the object of synchronisation, a monitor? What is its purpose?

- What things could be used as a monitor?

  It is syntactically wrong that a class could be used as a monitor. Although,
  it is possible to use the class object of a class for this purpose.

- What is the monitor of an operation marked *synchronised*?

- Let there are four operations. What operations are not mutually exclusive
  if called on different tasks?

    void op1() {}
    synchronised void op2() {}
    synchronised void op3() {}
    void op4() { synchronised(lock1) {} }

Solve the following bank issue:

- Create a type Cashpoint. Provide an operation that takes a user's name and the
  amount to be withdrawn from her account.

- There are step to withdraw an account:

  - Print the message "NAME has come to the cashpoint" and wait for 2 seconds.

  - Validate that there are enough money in the cashpoint. If the validation
    passed, print the message "NAME has withdrawn AMOUNT rubles". Otherwise,
    print the message "There is no enough money for NAME."

- Create a few tasks. Each tasks represent a user and an amount to withdraw for
  her. Make it so that there is no enough money for some users.

- Organise the work of cashpoint in to ways:

  - Only one task is served at a time. Use *join* to make other tasks to wait
    to be served.

  - Any number of tasks are served at a time. Use a monitor to validate there are
    enough money.

### Atomic and Volatile

Let get back to the counter problem:

- There is a class Counter with an integral attribute *count*.

- Let the value of the attribute is incremented one thousand times on a one task.
  And it is decremented one thousand time and an other task in parallel.

- The result value of the attribute MUST BE zero.

Actually, to increment or to decrement an integral value means a sequence of three
operations:

- load the current value of the attribute into a register

- increment or decrement the value

- write the result into the attribute

Indeed, all these operations MUST BE performed as a critical section, acquiring
the same monitor, for example.

The same time, some hardware platforms provide instructions to perform such
operations at once, so called atomically, without the need to use a monitor for
this. For such a case, there are so called atomic wrappers of primitive types in
Java, e.g. *AtomicInteger*. Such types provide operation to update the values of
the basic types at once. For example, the operations *getAndIncrement*,
*compareAndExchange* .

There is the keyword *volatile* also. If a variable is declared with this
specifier:

- When read, the value of this variable is got from a local cache or the memory,
  not from a copy for a specific task if provided by a translator.

- When written, the value of this variable is written into cache and brings
  updating of memory and caches.

Solve the counter problem:

- Provide a type with the integer attribute *count*

- Increment the value of this attribute one thousand times on a one task and
  decrement it the same number of times on an other one in parallel

- The result value MUST BE zero

### Interview about Concurrency

The following questions MUST BE answered to be hired on a position of Junior
Java Plus Plus programmer:

- What is multithreading?

  To answer that it is ability to perform several jobs on multiple tasks is wrong.
  It seams that it is right to point that multithreading is the ability to perform
  several tasks as a single process. So that, this tasks shares some resources
  without usage of IPC mechanisms.

- Is it possible to stop a thread after it starts? If so, what are the methods?

  It is just wrong to specify the interrupt operation. It just sets a flag that the
  thread should terminate. Moreover, the answer is no in general. On \*nix, it could
  be required to send a signal to the task.

- Why stopping a task with the stop operation is not recommended?

  It is wrong to answer that it does not left the task to terminate gracefully.
  In contrast, it is not recommended to write tasks that will not stop themselves
  after the interrupt operation called.

- What happens after the operation interrupt has been called? Why this method
  is safer that others?

  It is wrong to answer that this method is safer because it does not stop a task
  actually. At the first, the meaning of the word safer MUST BE considered.

- What does the join operation?

- How to get a reference on the main thread?

  It is not correct to mention the operation *currentThread*. In Java, the main
  thread is a task on which the operation main is executed. Although, it seams to be
  wrong if a task depends on such a reference.

- Why it is required to put the sleep and join operations into a try-cache
  statement? What exception could be risen and at what point?

- What are the methods to synchronise threads?

- What is the monitor if an operation is declared with the *synchronised* specifier?

- Let some operations of a type is declared with the *synchronised* specifier. If some
  task calls a synchronised operation, is it possible to call an other synchronised /
  not synchronised operation on an other task at the same time?

- What are daemon tasks?

- What are methods to create a task?

- What methods to create a task is preferable and why?

- What is the different between operations run and start?

### CountDownLatch and ExecutorService

Let it is required to perform ten tasks in parallel. Let a task print
the word start and their own ordinal number, wait for a second, then
print the word finish and terminate.

There are ways to wait for the completion of this tasks:

- Store references onto task into a collection and call the operation
  join on them in a loop

- Use the *CountDonwLatch* counter to wait for termination of a specified
  number of tasks

Let it is required to perform a lot of jobs on dedicated tasks. It is not rational
to create a large number of tasks at the same time. Instead, use an implementation
of ExecutorService, that creates a poll of a specified number of tasks. The service
will perform jobs on free tasks.

Solve the following computational issue:

- Provide an operation to calculate and print the sum of all even integers from
  0 to 1 000 000

- Provide an operation to calculate and print the sum of all integers from 0 to
  1 000 000, that are divided by 7 with a zero remainder

- Provide an operation to create a collection of 1 000 integers and fill it with
  random values. Then calculate and print the number of even integers in this
  collection.

- Use an executor service to perform this jobs.

- Wait for completions of the jobs above with *CountDownLatch* and print the time
  of execution.

- Compare the time of execution when the poll of execution consists of three
  tasks and when it consists of a single task.

### ThreadFactory, Callable and Future

An ExecutorService could be provided with a ThreadFactory on construction. To
get tasks, the service will call an operation of this factory.

Solve the following issue:

- Create a job to print integers in order, one per second. The job MUST BE
  performed on a task of an ExecutorService.

- Configure tasks of this service to run as *daemons*, e.g. to be terminated
  run on a *daemon* task, e.g. to be terminated when all not *daemon* tasks
  terminate.

- Print points on the main task, one per second, and then terminate.

Normally, it is required to yield the result of execution of a task from an other
task, e.g. from the main task.

Solve the following issue:

- Create a task to emulate loading of the name of a user and an other task
  to emulate loading of her age

- While loading, print points

- After the name and age are loaded, print "Name is NAME, age is AGE". Then
  stop printing points and terminate.

The ExecutorService provides a way to return the result of execution of a job.
There is an operation *submit*:

- It could be passed with a Callable, an interface with the only operation
  *call* that returns a result and could throw Exception

- It returns an instance of Future, an interface that provides an operation *get*
  to wait for the completion and then to retrieve the result.

Solve the previous issue using the operation *submit*.

### Synchronised Queue

Solve the following queue issue:

- Implement a BlockeingQueue, a FIFO queue of Runnable with two operations:

  - The add operation adds a Runnable at the tail of the queue

  - The take operation remove a Runnable from the head of the queue

- Create a task that remove elements of the queue and run them on dedicated tasks

- Fill a queue with a few tasks on the main task

A monitor, i.e. any object, could be user both to synchronise the access to the
queue and to wait until it is not empty. There are operations *wait*, *nofity* and
*notifyAll* for it. This operation MUST BE called on a tasks that holds the monitor.

There are blocking queue in Java Standard Library, e.g. LinkedBlockingQueue. Take
attention that this queues does not accept null elements.

Solve the following multitask issue:

- Create three tasks, each task prints a later five times.

  The first task prints the later A, the second - B, the third - C.

- Organise execution of tasks in such a way that the string ABCABCABCABCABC will
  be printed.

  DO NOT use operations sleep and join. It is REQUIRED to use operations wait and
  notifyAll.

### Mutual Exclusion

Solve the following transfer of value problem:

- Let there is a class with two attributes, *first* and *second*, to keep
  non negative integers

- Let there are two operations, a one to transfer some value from the first
  attribute to the one, an other one to transfer some value in the opposite
  direction. The values of attributes MUST BE kept non negative.

- Let there are two monitors, a one for the first operation and an other one
  for the other one. To preserve the total, each of operations MUST acquire
  both monitors.

- Create two task, the first calls the first operation and the second - the
  second one.

Let there are two resources, 1 and 2, and two tasks, A and B. And let each
of the tasks REQUIRES to acquire both this resources to succeed and then
to release this resources.

Consider the following case. Let the task A has acquired only the resource 1
and the task B has acquired only the resource 2. Then the first 1 waits
until it could acquire the resource 2 and the task 2 waits until it could
acquire the resource 1.

The logic of a program MUST either prevent such a case or to resolve it,
providing a one of tasks with both resources. But to be hired on a position of
a high society Java Junior Programmer, it is enough to know that such a case is
called a *dead lock*.

Solve the following multifunctional problem:

- Create a type that emulates scanning and printing of documents, operations
  print and scan that accepts a number of pages as a parameter N

  The operation print prints "Printed 1 page(s)", "Printed 2 page(s)" and so
  on, with some delay, until the name N is printed. The operation scan does the
  same thing, except it prints "Scanned" instead "Printed".

- Synchronise the operations in such a way that one print operation and one scan
  operation can be executed in parallel. But it is impossible to execute more
  than one print or more than one scan operation simultaneously.

### MT-safe Collections

Let there is a collection. And elements are added into this collection on several
tasks. If so, the addition of elements MUST BE synchronised.

There are ways to synchronise collections of Java Collection Framework:

- To wrap a collection with a synchronising operation of the type Collections, e.g.
  with the *synchronisedList* operation. In such a case, all operations are
  synchronised with a single monitor.

- To use synchronised versions of collections, e.g. *CopyOnWriteArrayList*. In such
  a case, to change a collection, a copy is first created, changes are made to the
  copy, and then the copy replaces the original. If so, at a given moment of time,
  only one task can modify the collection, but reading could be performed without
  blocking.

### Semaphores and Races

Let a hundreds of files MUST BE downloaded. The question is, what is better, to
download them sequentially or in parallel? Similarly, there are cases when it is
REQUIRED to limit the number of tasks using a resource at the same time.

Consider the following VFS limiting problem:

- Provide an operation to emulate access to the VFS system, with the sleep
  operation for example

- Create ten tasks that works some work, calls this VFS operation and then
  terminates

- Limit the number of tasks that calls this VFS operation at the same time

To solve such a task the type Semaphore could be used. An instance of this type
can be set with an integer, a number of units of a resource. Then, the operation
acquire can be used to hold a unit of the resource for exclusive access, and the
operation release can be used to release it.

Consider the following VFS parties problem:

- Let there are several tasks that MUST complete some preparatory work and then
  start performing a common work simultaneously

- Exactly a specific number of tasks MUST start at the same time.

To accomplish this, a type CyclicBarrier can be used. Its instance is set with
an integer, the minimal number of tasks that MUST BE waiting on the barrier before
this number of tasks will be allowed to go out.

Solve the following car race problem:

- Each car must prepare to the start, drive a section of road, drive
  through a tunnel, drive a section of road.

- There are ten cars in total.

- Each car takes different time to prepare to the race but all cars must start
  simultaneously.

- Only three cars can drive through the tunnel.

- When all ten cars have finished, print the number of the winner and the list of
  all cars with them results ordered by the numbers of cars.

- The time taken by a car to prepare for the race and to drive each section must
  be set by a random number.
