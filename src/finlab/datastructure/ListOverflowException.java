package finlab.datastructure;

/**
 * Class: ListOverflowException
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 *
 * Gets thrown when a list has no space
 */
public class ListOverflowException extends OutOfMemoryError{
    public ListOverflowException() {
        super();
    }
    public ListOverflowException(String s) {
        super(s);
    }
}
