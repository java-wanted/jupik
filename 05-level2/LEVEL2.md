## 5 LEVEL 2

### JUnit

In the food production to check that a logic satisties some expectation auto
tests are used. In Java a library JUnit could be used to write such tests.

JDK does not contains the library JUnit. To compile a probram with such external
libraries it is possible to use so called build tools, e.g. Gradle and Maven.

In general the idea of auto testing is:

- To provide an expected result of execution of some logic

- To calculate the actual result of the execution

- To validate that the actual result exuals the expected one.

Solve the following computational issue:

- Create a class that implements the following operations:

    - Addition, multiplication, division of two double values

    - Rising a double value at the power of two

- Provide auto tests for each operation

### JUnit 2

In a JUnit test it is possible:

- To execute an operation before each tests with the annotation *BeforeEach*
  (*Before* for JUnit4)

- To execute an operation after each test, the annotation *AfterEach*
  (*After* for JUnit4)

- To test an exeption is rised in a test with the assertion *assertThrows*
  (with the parameter expected of the *Test* annotation for JUnit4)

Also, it could be preffered to test an operation against a single set of input
data in a dedicated test.

Solve the following issues:

- Extend the calculator with operations that accepts string representations
  of valules

- Parametrise tests of operations to be run for a single instance of input
  data.
