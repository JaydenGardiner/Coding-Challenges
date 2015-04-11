import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Finds factory view log co-occurances for Maker's Row.
 * 
 * Big O time complexity of my solution: O(N^2)
 * Using two for loops / pointers to find the pairs makes this operation
 * O(N^2) for each line, but considering you iterate over k number of
 * lines only once, the following operations are thus O(N^2). 
 * k - number of lines + N^2 - # of elements
 * I don't see a way to make this faster.
 * 
 * @author Jayden Gardiner
 * @version 1.3
 */

public class FindCoOccurrences {

    public static void main(String[] args) throws Exception {
        
        /*
         * Take in input from System.in, then scan the input file for
         * N, the minimum number of co-occurrences for a factory pair
         * to appear in the output (first line).
         *
         * Throw an exception if input for N is not an integer >= 0.
         */
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        try {
            N = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Invalid input.");
            throw new Exception();
        }
        if (N < 0) {
            System.err.println("Invalid input.");
            throw new Exception();
        }
        
        /*
         * Iterate through each line.
         * Split the list of companies by "," and find the pairs.
         * Put each pair into a hashmap as a key. Value = number of co-occurrences
         * Increment its value if a pair is found again.
         * compareTo is used to ensure alphabetical order within pairs.
         *
         * Throw an exception if the factory view log data is empty.
         */
        Map<String, Integer> map = new HashMap<>();
        if (!scanner.hasNextLine()) {
            System.err.println("Invalid input.");
            throw new Exception();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(",");
            for (int i = 0; i < lineArray.length; i++) {
                for (int j = i + 1; j < lineArray.length; j++) {
                    String pairStr = "";
                    String a = lineArray[i];
                    String b = lineArray[j];
                    int compare = a.compareTo(b);
                    if (compare < 0) {
                        pairStr = a + "," + b;
                    } else if (compare > 0) {
                        pairStr = b + "," + a;
                    }
                    if (a != b) {
                        Integer numOfCoOccurrences = map.get(pairStr);
                        if (numOfCoOccurrences != null) {
                            map.put(pairStr, numOfCoOccurrences + 1);
                        } else {
                            map.put(pairStr, 1);
                        }
                    }
                }
            }
        }
        
        //Add each pair with the number of occurances >= N to a list.
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= N) {
                list.add((entry.getKey()));
            }
        }
        
        //Sort the list based on alphabetical order.
        java.util.Collections.sort(list);

        //Print the items in the list.
        for (String str: list) {
            System.out.println(str);
        }

    }
}