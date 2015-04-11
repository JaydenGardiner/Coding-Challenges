import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CharacterReverseChallenge {

/*
 Coding challenge for Palantir.
 Reverses h's and t's so there are no t's before an h.
 For example, "the theater" will produce "hte hteater".
 */

    static String characterReverse(String input) {
        String str = "";
        
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) != 't') {
                str += input.charAt(i);
                i++;
                System.out.println(str);
            } else if (input.charAt(i) == 't') {
                String tStr = "";
                while (input.charAt(i) == 't') {
                    tStr += 't';
                    i++;
                }
                if (input.charAt(i) == 'h') {
                    tStr = 'h' + tStr;
                }
            }
        }
        
        return str;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        _input = in.nextLine();
        
        res = characterReverse("theater");
        System.out.println(res);
        
    }
}