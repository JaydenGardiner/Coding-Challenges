import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindFirstNonRepeatingCharacterChallenge {
    /*
     * This coding challenge for Palantir was to find the first nonrepeating character of a string.
     * For example, input of "aaabbbdgsggdd" would return "s".
     */
    
    static String firstNonRepeatingCharacter(String input) {
        /* Add chars to a hashmap.
         * Value = count of the number of times the letter appears.
         * Go through the string and check each letter in the hashmap.
         * If count == 1, return char.
         */
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            Integer count = map.get(new Character (c));
            if (count != null) {
                map.put(c, new Integer(count + 1));
            } else {
                map.put(c, 1);
            }
            i++;
        }
        
        String returnValue = "";
        int j = 0;
        while (j < input.length()) {
            if (map.get(input.charAt(j)) == 0) {
                returnValue += map.get(input.charAt(j));
            }
        }
        
        return returnValue;
    }


public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        _input = in.nextLine();
        
        res = firstNonRepeatingCharacter(_input);
        System.out.println(res);
        
    }
}