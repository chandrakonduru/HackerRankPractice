
package com.hackerRankPractice.main;
// Problem Statement: You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BirthDayCandles {

    public static int countTallestCandles(List<Integer> candles) {
        // Sort the list in ascending order
        Collections.sort(candles);

        // Get the maximum height (last element after sorting)
        int maxHeight = candles.get(candles.size() - 1);

        // Count how many candles have the maximum height
        int count = 0;
        for (int height : candles) {
            if (height == maxHeight) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of candles
        int n = scanner.nextInt();

        // Read the candle heights
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candles.add(scanner.nextInt());
        }

        // Get the result and print it
        int result = countTallestCandles(candles);
        System.out.println(result);

        scanner.close();
    }
}
// Problem Statement: You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.