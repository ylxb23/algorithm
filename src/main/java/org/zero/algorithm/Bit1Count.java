package org.zero.algorithm;

import java.util.StringJoiner;

public class Bit1Count {

    public static void main(String[] args) {
        int n = 20;
        print(sim01(n));
        print(sim02(n));
    }

    public static int[] sim01(int n) {
        int[] arr = new int[n+1];
        int k=0;
        for(int i=0; i<=n; i++) {
            k=i;
            if(k % 2 != 0) arr[i] += 1;
            while(k>0) {
                if((k = k>>>1) % 2 != 0)
                    arr[i] += 1;
            }
        }
        return arr;
    }

    /**
     * 求正整数位数上为1的个数
     * @param n
     * @return
     */
    public static int[] sim02(int n) {
        int[] arr = new int[n+1];
        int highBits = 0;
        for(int i=1; i<=n; i++) {
            if((i & (i - 1)) == 0) {
                highBits = i;
            }
            arr[i] = arr[i - highBits] + 1;
        }
        return arr;
    }

    private static void print(int[] arr) {
        StringJoiner joiner = new StringJoiner(", ");
        for(int a : arr) joiner.add(String.valueOf(a));
        System.out.println((arr.length-1) + ": " + joiner);
    }
}
