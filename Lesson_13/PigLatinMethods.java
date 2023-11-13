package Lesson_13;


/**
 * Write a description of class PiglatinatorMethods here.
 *
 * @author Peyton Slape
 * @version 11/13/2023
 */
public class PigLatinMethods {
    public enum PigLatinCase {
        NORMAL,
        START_VOWEL,
        NO_VOWELS
    }
    public static String toPigLatin(String englishWord) {
        PigLatinCase pigCase = getCase(englishWord);
        int vowelCount = 0;
        String start = "", end = "";
        switch(pigCase) {
            case NORMAL:
                return null;
            default:
                return null;
        }
    }
    private static PigLatinCase getCase(String englishWord) {
        int vowelCount = 0;
        for(char ch : englishWord.toCharArray()) {
            if(isVowel(ch)) {
                vowelCount++;
                if(englishWord.indexOf(ch) == 1) return PigLatinCase.START_VOWEL;
            }
        }
        if(vowelCount > 0) {
            return PigLatinCase.NORMAL;
        } else {
            return PigLatinCase.NO_VOWELS;
        }
    }
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
