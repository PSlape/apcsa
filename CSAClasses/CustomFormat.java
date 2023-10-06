package CSAClasses;


/**
 * Write a description of class CustomFormat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class CustomFormat {
        // This method formats the inputted text to the center of a number of spaces equal to the parameter spaces
    public static String center(String in, int spaces) {
        int spacesOnEachSide = (int) Math.round(spaces / 2.0);
        return space(spacesOnEachSide) + in + space(spacesOnEachSide);
    }
        // This method formats the inputted text to the right of a number of spaces equal to the parameter spaces
    public static String right(String in, int spaces) {
        return space(spaces) + in;
    }
        // This method formats the inputted text to the left of a number of spaces equal to the parameter spaces
    public static String left(String in, int spaces) {
        return in + space(spaces);
    }
        // This method returns a String containing a number of space characters equal to the parameter spaces
    public static String space(int spaces) throws OutOfBoundsException {
        if(spaces < 0) throw new OutOfBoundsException("Spaces cannot be less than or equal to zero.");
        String out = "";
        for(int ch = 0; ch < spaces; ch++) {
            out += " ";
        }
        return out;
    }
}

