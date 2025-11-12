package com.hackerRankPractice.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Problem Statement:
 * Given an array of integers nums, return the number of good pairs. A pair (i,
 * j) is called good if nums[i] == nums[j] and i < j. 1 <= nums.length <= 100 1
 * <= nums[i] <= 100
 */
public class PairProblem {
	
public int numIdenticalPairs(int[] nums) {
	
	int count=0;
	for(int i=0;i<nums.length;i++) {
		for(int j=i+1;j<nums.length;j++) {
			if(nums[i]==nums[j]) {
				count++;
			}

		}
	}
	return count;
    }

public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter array elements separated by spaces:");
    String[] numStrs = reader.readLine().trim().split(" ");
    int[] nums = new int[numStrs.length];
    for (int i = 0; i < numStrs.length; i++) {
        nums[i] = Integer.parseInt(numStrs[i]);
    }
   

    PairProblem pair = new PairProblem();
    int result = pair.numIdenticalPairs(nums);
    System.out.print("Result: "+ result);
    
    System.out.println();
}
	

}
