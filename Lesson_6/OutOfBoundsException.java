package Lesson_6;


/**
 * Write a description of class OutOfBoundsException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OutOfBoundsException extends RuntimeException{
    public OutOfBoundsException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public OutOfBoundsException() {
        super();
    }
    public OutOfBoundsException(String errorMessage) {
        super(errorMessage);
    }
}
