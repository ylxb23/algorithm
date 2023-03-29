package org.zero.leetcode.easy;

public class ValidSemb {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        if(s.length() % 2 != 0) {
            return false;
        }
        int[] stack = new int[s.length()];
        stack[0] = mapToNum(s.charAt(0));
        int idx = 0;
        int maped;
        for(int i=1; i<s.length(); i++) {
            maped = mapToNum(s.charAt(i));
            if(idx == -1) {
                stack[0] = maped;
                idx = 0;
                continue;
            }
            if(stack[idx] + maped == 0) {
                stack[idx] = 0;
                idx = idx - 1;
            } else {
                stack[idx+1] = maped;
                idx++;
            }
        }
        return idx == -1;
    }

    public static int mapToNum(char c) {
        if(c == '(') {
            return 1;
        } else if(c == ')') {
            return -1;
        } else if(c == '[') {
            return 2;
        } else if(c == ']') {
            return -2;
        } else if(c == '{') {
            return 3;
        } else if(c == '}') {
            return -3;
        }
        return 0;
    }
}
