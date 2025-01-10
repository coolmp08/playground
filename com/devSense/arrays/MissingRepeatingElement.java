package com.devSense.arrays;


import java.util.Arrays;

/**
 * Input: arr[] = {3, 1, 3}
 * Output: Missing = 2, Repeating = 3
 * Explanation: In the array, 2 is missing and 3 occurs twice
 * <p>
 * <p>
 * Input: arr[] = {4, 3, 6, 2, 1, 1}
 * Output: Missing = 5, Repeating = 1
 */
public class MissingRepeatingElement {

    public static void main(String[] args) {

//        int[] arr = { 7, 3, 4, 5, 5, 6, 2 };
        int[] arr = {3, 1, 3};
        missingRepeatedElementInArray(arr);
    }

    static void missingRepeatedElementInArray(int[] arr) {

        int n = arr.length;
        boolean[] visited = new boolean[n+1];
        int repeating = -1, missing = -1;

        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[arr[i]])
                repeating = arr[i];
            else
                visited[arr[i]] = true;
        }

        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {
                missing = j;
                break;
            }
        }
        System.out.println("Repeating : " + repeating);
        System.out.println("Missing : " + missing);
    }
}
