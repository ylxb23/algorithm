package org.zero.leetcode.hard;

public class FindMidVal {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2,5}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid1, mid2; // 取第 mid1个 和 mid2个元素的值, mid2 >= mid1
        if(total == 1 || total % 2 == 1) {
            mid1 = mid2 = total / 2;
        } else {
            mid1 = total / 2 - 1;
            mid2 = mid1 + 1;
        }
        int i=0, j=0;
        int curr;
        int mid1Val=0, mid2Val=0;
        for(int idx = 0; idx <= mid2; idx++) {
            if(i == nums1.length) {
                curr = nums2[j];
                j++;
            } else if(j == nums2.length) {
                curr = nums1[i];
                i++;
            } else if(nums1[i] < nums2[j]) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
            if(idx == mid1) {
                mid1Val = curr;
            }
            if(idx == mid2) {
                mid2Val = curr;
            }
        }
        return (double)(mid1Val+mid2Val) / 2;
    }
}
