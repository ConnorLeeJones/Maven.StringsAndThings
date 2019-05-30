package io.zipcoder;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
            String[] sentenceArray = input.split(" ");
            int count = 0;

            for (String element : sentenceArray){
                if (element.charAt(element.length() - 1) == 'y' || element.charAt(element.length() - 1) == 'z'){
                      count++;
                }
            }
        System.out.println(sentenceArray.toString());
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        base = base.replace(remove, "");
        return base;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        String is = "is";
        String not = "not";

        int isNumber = 0;
        int notNumber = 0;

        Pattern pattern = Pattern.compile(is);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            isNumber++;
        }

        pattern = Pattern.compile(not);
        matcher = pattern.matcher(input);

        while (matcher.find()) {
            notNumber++;
        }

        return notNumber == isNumber;

    }




    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        //String[] stringArray = input;

        boolean boul = true;

        for (int i = 1; i < input.length() - 1; i++) {
            if (input.charAt(i) == 'g') {
                if (!((input.charAt(i - 1) == 'g') || (input.charAt(i + 1) == 'g'))) {
                    boul = false;
                    break;
                }
            }
        }
            return boul;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int trips = 0;
        String[] inputArr = input.split("");

        for (int i = 0; i < inputArr.length - 2; i++){
            if (inputArr[i].equals(inputArr[i+1]) && inputArr[i].equals(inputArr[i+2]))
                trips++;
        }

        return trips;
    }
}
