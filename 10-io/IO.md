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
