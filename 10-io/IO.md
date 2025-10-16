## 10 Input Output

### Introduction

There is a type File in Java. An instance of this type describes a path to
a file or a directory.

The File type provides some operations, e.g. an operation to check the file
exists on VFS, to check it is the directory of some file, to create the file,
to iterate over a list of files within a directory.

Solve the following VFS problem:

- Create a few nested directories, *d1/d2/d3*

- Create a few files within the directory *d3*

- Print the absolute patches of files whose names start with the letter *A*

### Reading of Files

In Java, to read some file from VFS, the file MUST BE converted to a stream
of bytes.

There is an abstract type InputStream to read as a stream of bytes. To read
data from a file, it is REQUIRED to use its sub type, FileInputStream.

If a stream has been processed, it SHOULD BE closed to release resources. For
example in the finally branch of a try-catch statement.

Let a type implements the interface AutoClosable. To simplify logic, an instance
of a such type could be instantiated with try-with-resources statement. If so, the
close operations of the such will be called automatically.

For IO types, use its ancestor, the Closable interface, instead:

    try (AutoClosable instance = new FileInputStrim(path))
    {
        ...
    }
    catch (IOEXception e)
    {
        ...
    }

Solve the following VFS problem:

- Create a directory and a file within it. Fill the file with some names

  Write names in ASCII.

- Read data from this file and output onto a terminal

### Buffered File Input

In Java, the type String is immutabe, meaning that if a string must be modified,
e.g. it must be appended with a single character, the new string must be created.
If it is required to modify a string, the StringBuilder type could be used instead.
A similiar type StringBuffer is thread-safe also.

To improve performance, do not read files by single byte at a time. Read data into
an array, a few bytes at once.

To read data as a stream of characters the InputStreamReader could be used instead.

Solve the following VFS name space problem:

- Create a file with a single line of names, separated by spaces

- Read names into a list of names

- Leave only names that starts with the latter A

- Output the result onto a terminal

### Buffered Input Output

To write a stream of bytes into a file, FileOutputStream could be used.

To write and read data with buffering, it is possible to use instances of
BufferedOutputStream and BufferedInputStream correspondently.

There is a type Scanner. It allow to read an InputStream as a sequence of
strings and numbers.

Solve the following VFS naming problem:

- Prompt and read names, a one per line, until the word exit is read

- Append each name into a file

- After the word exit, read the file and print date onto a terminal


### Random Access Files

There are types to handle data as byte streams:

- InputStream and OutputStream - abstract types to handle bytes

- FileInputStream and FileOutputStream - to handle files

- BufferedInputStream and BufferedOutputStream - to buffer bytes of such streams

There are type to handle data as character streams:

- Reader and Writer - abstract types to handle characters

- FileReader and FileWriter - to handle files

- BufferedReader and BufferedWriter - to buffer characters of such streams

- InputStreamReader and OutputStreamWriter - to handle byte streams as character
  streams

There is a type RandomAccessFiles to handle a file like an array of bytes. In such
a way, the file could be opened for reading or for reading and writing.

Solve the following VFS page problem:

- Create a text of a great size.

- Write a program that requests a number of a page of a document and outputs
  this page onto a terminal

  Consider that a page takes 300 bytes within the file.

- Or terminates if the word exit entered
