package org.zero.algorithm;

/**
 * 动态规划
 * 连续子序列最大乘积值
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-3,4}));
        System.out.println(maxProduct(new int[]{2,3,-3,4,8,-2}));
        System.out.println(maxProduct(new int[]{2,3,-3,4,8}));
    }


    public static int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int positiveMax = nums[0], negtiveMin = nums[0], result = nums[0];
        for(int i=1; i< nums.length; i++) {
            int prePositiveMax = positiveMax, preNegtiveMin = negtiveMin;
            positiveMax = max(prePositiveMax * nums[i], max(nums[i], preNegtiveMin * nums[i]));
            negtiveMin = min(preNegtiveMin * nums[i], min(nums[i], prePositiveMax * nums[i]));
            result = max(positiveMax, result);
        }
        return result;
    }

    private static int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    private static int min(int a, int b) {
        if(a < b) {
            return a;
        }
        return b;
    }
}
