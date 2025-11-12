package com.hackerRankPractice.main;

 class ValidParentheses {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // Odd length can't be valid

        // Left to right: try to keep balance >= 0
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') balance++;
                else balance--;
            } else {
                balance++; // treat unlocked as '('
            }
            if (balance < 0) return false;
        }

        // Right to left: try to keep balance >= 0
        balance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') balance++;
                else balance--;
            } else {
                balance++; // treat unlocked as ')'
            }
            if (balance < 0) return false;
        }
        return true;
    }
}