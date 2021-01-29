package main.java.com.questions;

import java.util.Arrays;

public class anagrams {
    public static void main(String[] args) {
        String first = "Desperation";
        String second = "A Rope Ends It";
        System.out.printf("Are the words '%s' and '%s' an anagram?%n", first, second);
        System.out.println("The answer is: " + anagramAnalyzer(first, second));
    }

    public static boolean anagramAnalyzer(String firstWord, String secondWord) {
        firstWord = firstWord.replaceAll("\\s+", "");
        secondWord = secondWord.replaceAll("\\s+", "");
        if (firstWord.length() == secondWord.length()) {
            char[] firstWordCharArray = firstWord.toLowerCase().toCharArray();
            char[] secondWordCharArray = secondWord.toLowerCase().toCharArray();
            Arrays.sort(firstWordCharArray);
            Arrays.sort(secondWordCharArray);
            for (int i = 0; i < firstWord.length(); i++) {
                if (firstWordCharArray[i] != secondWordCharArray[i])
                    return false;
            }
            return true;
        }
        return false;
    }
}
