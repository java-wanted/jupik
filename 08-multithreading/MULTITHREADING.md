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

### ThreadFactory, Callable and Feature

An ExecutorService could be provided with a ThreadFactory on construction. To
get tasks, the service will call an operation of this factory.

Solve the following issue:

- Create a job to print integers in order, one per second. The job MUST BE
  performed on a task of an ExecutorService.

- Configure tasks of this service to run as *daemons*, e.g. to be terminated
  run on a *daemon* task, e.g. to be terminated when all not *daemon* tasks
  terminate.

- Print points on the main task, one per second, and then terminate.
