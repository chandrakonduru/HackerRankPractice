package com.hackerRankPractice.anotherClass;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

    static class DSU {
        int[] parent;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
            }
        }
    }

    public  List<List<String>> merge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;

        // Step 1: Assign index to each email and map email to name
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                }
                emailToName.put(email, name);
            }
        }

        DSU dsu = new DSU(emailCount);

        // Step 2: Union emails in the same account
        for (List<String> account : accounts) {
            int firstEmailIndex = emailToIndex.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                dsu.union(firstEmailIndex, emailToIndex.get(account.get(i)));
            }
        }

        // Step 3: Group emails by root parent
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = dsu.find(emailToIndex.get(email));
            indexToEmails.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        // Step 4: Build the result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }
}