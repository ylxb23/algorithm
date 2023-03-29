package org.zero.leetcode.easy;

import java.util.Arrays;

public class DeleteDuplicateArrayItem {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8, 9, 10, 10};
        int[] expectArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int len = deleteDuplicateArrayItem(nums);
        System.out.println("len=" + len);
        System.out.println("array: " + Arrays.toString(nums));
        boolean access = true;
        if (expectArr.length != len) {
            access = false;
        } else {
            for (int i = 0; i < len; i++) {
                if (nums[i] != expectArr[i]) {
                    access = false;
                }
            }
        }
        if(!access) {
            System.err.println("can not access");
        } else {
            System.out.println("access");
        }
    }

    private static int deleteDuplicateArrayItem(int[] nums) {
        int len = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[len - 1]) {
                nums[len] = nums[i];
                len ++;
            }
        }
        return len;
    }
}

