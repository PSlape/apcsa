package Lesson_11;


/**
 * Write a description of class Status here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Status {
    boolean isEligible;
    String reason;
    
    public Status(boolean isEligible) {
        this.isEligible = isEligible;
        reason = "No reason provided.";
    }
    public Status(boolean isEligible, String reason) {
        this.isEligible = isEligible;
        this.reason = reason;
    }
}