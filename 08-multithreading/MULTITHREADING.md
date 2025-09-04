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
