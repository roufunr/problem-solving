package leetcode.random.exception_example;

public class Tester {
    public static void main(String[] args) {
        myPrint();
    }

    private static void myPrint() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }
}

//NullPointerException: Occurs when you try to access or perform an operation on an object reference that is null.
//
//ArrayIndexOutOfBoundsException: Happens when trying to access an array element at an invalid index.
//
//ArithmeticException: Occurs during arithmetic operations, such as division by zero.
//
//IllegalArgumentException: Thrown to indicate that a method has been passed an illegal or inappropriate argument.
//
//ClassCastException: Happens when attempting to cast an object to a type that is not compatible.
//
//NumberFormatException: Occurs when attempting to convert a string to a numeric format, but the string does not have the appropriate format.
//
//ConcurrentModificationException: Happens when an object is structurally modified in a way that is not permitted while iterating over it.
//
//UnsupportedOperationException: Thrown to indicate that the requested operation is not supported.
//
//IllegalStateException: Indicates that a method has been invoked at an illegal or inappropriate time or state.
//
//OutOfMemoryError: Represents that the Java Virtual Machine cannot allocate an object because it is out of memory.
