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

    /**
     * Translates an input word into Piglatin
     * 
     * @param englishWord The String to translate
     * @return The translated String
     */
    public static String toPigLatin(String englishWord) {
        PigLatinCase pigCase = getCase(englishWord);
        int vowelCount = 0;
        String start = "", end = "";
        switch(pigCase) {
            case NORMAL:
                return translateNormal(normal);
            case START_VOWEL:
                return translateStartVowel(normal);
            case NO_VOWELS:
                return translateNoVowel(normal);
            default:
                return null;
        }
    }

    /**
     * Returns which type of piglatin translation to use
     * 
     * @param englishWord The word to check the case of
     * @return Which type of translation to use
     */
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

    /**
     * Checks if a character is a vowel
     * 
     * @param ch The character to check
     * @return Whether or not the character is a vowel
     */
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    /**
     * 
     */
    private static String translateNormal(String str) {
        String first = "";
        String last = "";
        int endIndex = 0;
        for(int i = 0; i < str.length(); i++) {
            if(isVowel(str.charAt(i))) {
                endIndex = i;
                break;
            } else {
                first += str.charAt(i);
            }
        }
        for(int i = endIndex; i < str.length(); i++) {
            last += str.charAt(i);
        }
        return last + first + "ay";
    }

    private static String translateStartVowel(String str) {
        return str + "yay";
    }

    private static String translateNoVowel(String str) {
        return str + "ay";
    }

    
}
