package org.zero.algorithm;

/**
 * 动态规划：数组最大不连续递增子序列
 */
public class MaxIncrChildArraySize {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,4,1,5,9,2,6,5};
        System.out.println("size: " + maxSubArraySize(arr));
    }

    public static int maxSubArraySize(int[] arr) {
        if(arr.length == 1) {
            return 1;
        }
        int[] temp = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            temp[i] = 1;
        }
        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && temp[j]+1 > temp[i]) {
                    temp[i] = temp[j] + 1;
                }
            }
        }
        int max = temp[0];
        for(int i=1; i<arr.length; i++) {
            if(max < temp[i]) {
                max = temp[i];
            }
        }
        return max;
    }
}
