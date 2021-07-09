package org.zero.algorithm;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221)); // true
        System.out.println(isPalindrome(121));  // true
        System.out.println(isPalindrome(1211)); // false
        System.out.println(isPalindrome(22));   // true
        System.out.println(isPalindrome(2));    // true
    }

    

    /**
     * 是否为回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    public static long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
    }
}
