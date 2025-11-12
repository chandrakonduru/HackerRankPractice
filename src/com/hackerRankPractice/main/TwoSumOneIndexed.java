package com.hackerRankPractice.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TwoSumOneIndexed {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0]; // Should not reach here as per problem statement
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter array elements separated by spaces:");
        String[] numStrs = reader.readLine().trim().split(" ");
        int[] nums = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }
        System.out.println("Enter target integer:");
        int target = Integer.parseInt(reader.readLine().trim());
        TwoSumOneIndexed sol = new TwoSumOneIndexed();
        int[] result = sol.twoSum(nums, target);
        System.out.print("Result: ");
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}