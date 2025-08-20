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
