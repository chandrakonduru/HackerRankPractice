package com.hackerRankPractice.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0]; // return empty array if no solution
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
        TwoSum sol = new TwoSum();
        int[] result = sol.twoSum(nums, target);
        System.out.print("Result: ");
        for (int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}