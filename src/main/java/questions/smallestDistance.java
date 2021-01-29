package main.java.com.questions;

import java.util.Arrays;

public class smallestDistance {
    public static void main(String[] args) {
        int[] neighbours = {4, 8, 6, 1, 2, 9, 4};
        System.out.println("The index of the first number is: " + minimumDistance(neighbours));
    }

    public static int minimumDistance(int[] neighboursArray) {
        Arrays.sort(neighboursArray);
        int minDist = neighboursArray[1] - neighboursArray[0];
        int indexFirstElement = 0;
        int valueFirstElement = 0;
        for (int i = 0; i < neighboursArray.length - 1; i++) {
            if (minDist > (neighboursArray[i + 1] - neighboursArray[i])) {
                minDist = neighboursArray[i + 1] - neighboursArray[i];
                valueFirstElement = neighboursArray[i];
            }
        }
        for (int j = 0; j < neighboursArray.length; j++) {
            if (neighboursArray[j] == valueFirstElement) indexFirstElement = j;
        }
        return indexFirstElement;
    }
}
