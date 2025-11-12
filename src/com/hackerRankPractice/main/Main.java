package com.hackerRankPractice.main;

import java.util.Arrays;
import java.util.List;
import com.hackerRankPractice.anotherClass.AccountsMerge;

public class Main {

public static void main(String[] args) {
	
	AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("Mary", "mary@mail.com")
        );

        List<List<String>> result = accountsMerge.merge(accounts);
        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}

    