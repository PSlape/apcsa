package Lesson_14;

import java.lang.annotation.*;

/**
 * Annotation to indicate that the user should avoid using this method where possible.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public @interface AvoidUse {
    String reason() default "[Use should be avoided]";
}
