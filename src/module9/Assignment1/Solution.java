package module9.Assignment1;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int no_of_testcases = 6;
        int i = 0;
        while (i < no_of_testcases) {
            String inputFile = "C:\\Users\\Gopi Venkat Krishna\\IdeaProjects\\DatasStructures\\src\\module9\\Assignment1\\testcases\\input00" + i + ".txt";
            String outputFile = "C:\\Users\\Gopi Venkat Krishna\\IdeaProjects\\DatasStructures\\src\\module9\\Assignment1\\testcases\\output00" + i + ".txt";
            ReadInput(inputFile, outputFile);
            i++;
        }
    }

    private static String isPresent(String magazine, String ransom) {
        Hashtable<String, Integer> table = new Hashtable<>();
        String words[] = magazine.split(" ");
        for (String word : words) {
            if (table.containsKey(word))
                table.put(word, table.get(word) + 1);
            else
                table.put(word, 1);
        }
        words = ransom.split(" ");
        for (String word : words) {
            if (table.containsKey(word) && table.get(word) > 0)
                table.put(word, table.get(word) - 1);
            else
                return "No";
        }
        return "Yes";
    }


    public static void ReadInput(String inputFile, String outputFile) throws Exception {
        Scanner sc = new Scanner(new File(inputFile));
        String number_of_words = sc.nextLine(), magazine_words = sc.nextLine(), ransom_note = sc.nextLine();
        checkOutput(isPresent(magazine_words, ransom_note), outputFile);
    }

    public static void checkOutput(String output, String outputFile) throws Exception{
        Scanner sc = new Scanner(new File(outputFile));
        String fileOutput = sc.nextLine();
        if(output.equals(fileOutput))
            System.out.println("your output with file "+ outputFile+" Matched. This Test case passed");
        else
            System.out.println("Your output is not matching with output in file "+ outputFile);
    }
}