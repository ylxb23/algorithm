package org.zero.test;

import java.util.List;

public class Sel {

    public static void main(String[] args) {
        // [2,7,11,15]
        int[] arr = new int[]{2,7,11,15};
        int target = 9;

        int[] res = sel(arr, target);
        System.out.println(res[0] + ", " + res[1]);
    }

    public static int[] dp(int[] arr, int target) {
        // target数组 保存当前值是否与其他值相加等于 目标值target, boolean
        // for
        // map 的key等于值，val等于索引
        // 一个 for 去减 map(taget - map.key ) == 0

        // todo
        return null;
    }

    public static int[] sel(int[] arr, int target) {
        //
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
