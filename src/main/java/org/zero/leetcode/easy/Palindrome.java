package org.zero.leetcode.easy;

/**
 * 回文数
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(9));
        System.out.println(isPalindrome(99));
        System.out.println(isPalindrome(998));
        System.out.println(isPalindrome(9889));
    }

    public static boolean isPalindrome(int a) {
        if(a<0) {
            return false;
        }
        int b = 0;
        int t = a;
        while(t > 0) {
            b = t % 10 + b*10;
            t = t / 10;
        }
        return b == a;
    }
}
