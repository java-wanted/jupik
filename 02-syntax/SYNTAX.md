## 2 Syntax

### Variables

To define a variable its type MUST BE provided.

To fullfill the goal of the topic:

- Create a new class

- Define a variable

- Solve the following issue

    Let John has $100. Let Nick has five time more.

    How many dollars have John and Nick in total?

- Investigate the integral division

    When the dividend and the divisor are integral variables
    the quotient is an integral also. The remainder is lost.

    To get the remainder of the division the operator '%'
    could be used.

- Solve the following issue

    There is a variable that keeps a number of days, e.g. 10000.
    Represent this number as a number of years and months and days
    in the following condition:

    - If the variable keeps the number 365 the result MUST BE one year,
      zero mongth and zero day.

### Conditional operator

To fullfil the goal of the topic:

- Investigate the conditional operation if-else

    It allows to execute some logic iff a condition, i.e. a boolean expression
    is satisfied.

- Solve the following issue

    There is a variable that keeps the sum of dollars in your pocker. Write
    a logic that manages you what you MUST eat:

    - if there is more than ten dollars you are managed to eat a Pizza
    - if there is from six up to 10 dollars you are namaged to eat an Hamburher
    - otherwise you MUST BE managed to jre a Sandwich

### Integers

There are for integer types in Java:

- byte - one 8-bit byte
- short - two 8-bit bytes
- int - four 8-bit bytes
- long - eight 8-bit bytes

There are properties of numbers in Java:

- A variable of a longer type could be assigned with a shorter one

- A number literal, i.g. 10, is presented as an int

- There are few ways to increment a value of a variable

- To assign a variable of a shorter type a longer one MUST BE casted into
  a shorter type explicitly

- Solve the following issue

    There is a variable of the type int assigned with 1. There is a variable
    of the type byte. Assign the former with the value of the later.

### Floats

There are two type of fractional numbers in Java:

- float - four bytes
- double - eight bytes

There are properties of floats in Java:

- A float literal, i.g. 10.1 is presented as a double

    To declare a float literal to be presented as a float the literal
    MUST BE suffixed with f, e.g. 10.1f.

- Solve the following issue

    Create a few varables that contains the age of some members of a family.
    Calculate the mean of values of this variables.

### Characters

There is a single type for symbols in Java, the type char.

Actually, it is a numeric type but it could be assigned with
a character literal:

    char x = 'a';

- Solve the following issue

    - Create a few variables contining names and ages of members of a family.

    - Output the name and the age of each member, a member per line

        NAME ': ' AGE

### Boolean

There is a type to keep boolean values, the type boolean:

- It could be assigned with the value true or the value false

- It is the only type the condition of the confition operator MUST BE
  evaluated to

- The comparison operators returns a boolean value

- There are operators on boolean values: conjunction, disjunction and
  inversion.

Solve the following issue:

- Create a program that manages your to process some actions depending on
  the time of day and the weather.

- There MUST BE two variables, a one to keep whether the weather is good and
  an other one to keep whether it is night now.

- If it is day and the weather is fine the program MUST manage you to go out.

- If it is day and the weather is not fine the program MUST manage you to read
  a book.

- If it is night the program MUST manage you to sleep down.

- The block else MUST NOT be used in the program.

### String

There is a type String in Java. It is a reference type. This type allows to keep
strings of characters, i.g. the string 'Hello, World!'.

A String variables could contain TTY control characters, e.g. the character NL.

Solve the following issue:

- Create variables to keep a name, an age, generate a string in the format

        'Hi, ' NAME '!. You are ' AGE '!'

- Print the generated string on a terminal.

### Cycles

There are cycles in Java. Cycles allows to repeat some instructions until it is
required.

An example:

- Output onto a terminal natural numbers from one to one thousand.

    Use the loop while:

        number := 0
        while ++number <= 1000
            print number

An other example:

- Output onto a terminal all even natural numbers from one to thousand.

    Use the loop while again.

There is the loop for in Java. It allows to combive declaration of variables,
checking the loop condition and expressioins to update of some variables on lines
the operator for is declared:

    'for' DECLARATIONS ';' LOOP-CONDITION ';' EXPRESSIONS

Solve the following issue:

    - Use the loop for to output all integer numbers from one thousand down to
      zero if meet the following condition.

    - Output all numbers that are devided by three with the zero remainder.

### Arrays

There are arrays in Java. An array in Java is a named map from a continues
sequence of all integers starting from from zero, indexes, onto a set of unnamed
variables of the same type.

For example, to declare an array of N empty Strings the following statement
could be used:

    String []array = new String[N];

To assign a value to be the value of the i-th element of the array the following
statement could be used:

    array[i - 1] = "A string";

An issue:

    - Create an array of twelve String objects.
    - Fill it with the names of month.

An other issue:

    - Print out the array of the previous issue on a single line, months
      in order.

    - Print the space and comma between the names of months.

    - Print the dot after the name of the last months.

An other other issue:

    - Create an array of a few arbitrary integer numbers.

    - Print out elements of the array in the reverse order.

### Loop for each

There is a loop *for each* in Java. It could be used to iterate over elements
of arrays.

Solve an issue:

    - Create an array of names of some students.

Solve an other issue:

    - Create an array of one hundred integer numbers.

    - Assign the elements values from 100 up to 200 exclusive.

### Switch

There is the operator switch in Java.

Solve the following issue:

    - Receive the number of a month from a user.

    - Prints the name of the month on a terminal.
