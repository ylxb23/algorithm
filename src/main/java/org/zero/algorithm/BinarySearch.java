package org.zero.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9, 10};

        System.out.println(birSearch(arr, 3));  // 2
        System.out.println(birSearch(arr, 5));  // 4
        System.out.println(birSearch(arr, 99));  // -1
        System.out.println(birSearch(arr, 0));  // -1
    }

    /**
     * 二分查找
     * @param arr
     * @param searchNum
     * @return
     */
    private static int birSearch(int[] arr, int searchNum) {
        int size = arr.length;
        int min = 0;
        int max = size - 1;
        int idx = (min+max) / 2;
        while(min < max) {
            if(searchNum == arr[idx]) {
                return idx;
            } else  if(searchNum > arr[idx]) {
                min = idx + 1;
            } else {
                max = idx - 1;
            }
            idx = (min + max) / 2;
        }
        return -1;
    }


}
