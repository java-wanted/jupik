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
