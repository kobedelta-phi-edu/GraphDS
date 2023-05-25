package finlab.datastructure;

/**
 * Class: QueueException
 * Authored by: Group 1
 * Course: CS 211L Data Structures Laboratory
 *
 * Exception thrown when a mishandling or bug occurred in the utilization of the Queue interface
 */
public class QueueException extends RuntimeException {
    public QueueException(String err) {
        super(err);
    }

}