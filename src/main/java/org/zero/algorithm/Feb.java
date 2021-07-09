package org.zero.algorithm;

/**
 * 斐波那契数列
 */
public class Feb {

    public static void main(String[] args) {
        int n = 9;
        System.out.println("No." + n + " = " + feb(n));
        System.out.println("No." + n + " = " + febN(n));
    }

    /**
     * 动态规划方式
     * @param n
     * @return
     */
    static int febN(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int res1 = 1, res2 = 2;
        int res = res1 + res2;
        for(int i=3; i<=n; i++) {
            res = res1 + res2;
            res1 = res2;
            res2 = res;
        }
        return res;
    }

    /**
     * 递归方式
     * @param i
     * @return
     */
    static int feb(int i) {
        if(i == 1) {
            return 1;
        }
        if(i == 2) {
            return 2;
        }
        return feb(i-1) + feb(i - 2);
    }
}
