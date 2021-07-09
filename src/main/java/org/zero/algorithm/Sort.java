package org.zero.algorithm;


public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.print("Quick sorted: ");
        print(arr);

        System.out.print("Merge sorted: ");
        arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 7};
        int[] merged = mergeSort(arr, 0, arr.length - 1);
        print(merged);

        System.out.print("bible sorted: ");
        arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 7};
        bibleSort(arr);
        print(arr);
    }


    public static void bibleSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            for(int j=1; j<arr.length; j++) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] mergeSort(int[] arr, int low, int high) {
        if(low == high) {
            return new int[] {arr[low]};
        }
        int mid = low + (high - low) / 2;
        int[] left = mergeSort(arr, low, mid);
        int[] right = mergeSort(arr, mid+1, high);
        int[] sorted = new int[left.length + right.length];
        int i = 0, j = 0, m = 0;
        while(i < left.length && j < right.length) {
            sorted[m++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while(i < left.length) {
            sorted[m++] = left[i++];
        }
        while(j < right.length) {
            sorted[m++] = right[j++];
        }
        return sorted;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return ;
        }
        int i=low, j=high;
        int sentinel = arr[low];
        int tmp;
        while(i < j) {
            while(sentinel <= arr[j] && i < j) {
                j--;
            }
            while(sentinel >= arr[i] && i < j) {
                i++;
            }
            if(i < j) {
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[low] = arr[i];
        arr[i] = sentinel;
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }


    private static void print(int arr[]) {
        for(int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}
