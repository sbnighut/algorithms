package com.swapnil;

public class MergeSort {
    public MergeSort(int[] arr) {
        System.out.print("Before sorting: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]+" ");
        }

        MSort(arr, 0, arr.length - 1);
        System.out.print("After sorting: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]+" ");
        }
    }

    void MSort(int[] arr, int i, int j) {
        if (j == (i + 1) && (arr[i] > arr[j])) {
            Swap(arr, i, j);
        }

        else if (j == (i + 1) && (arr[i] < arr[j])) {
            // do nothing as the 2 values are already in order
        }

        else if (i < j) {
            MSort(arr, i, (i+((j - i) / 2)));
            MSort(arr, i+((j - i +2) / 2), j);
            Merge(arr, i, i+((j - i) / 2), i+((j - i + 2) / 2), j);
        }
    }

    void Merge(int[] arr, int i, int j, int x, int y) {
        int total = y-i+1;
        int[] q = new int[total];
        int index = i, index2 = x, l = 0;


        while (index <= (j) && index2 <= (y)) {
            if (arr[index] > arr[index2]) {
                q[l] = arr[index2];
                index2++;
            } else {
                q[l] = arr[index];
                index++;
            }
            l++;
        }

        while (l < total) {
            if (index > j) {
                q[l] = arr[index2];
                index2++;
            } else if (index2 >= y + 1) {
                q[l] = arr[index];
                index++;
            }
            l++;
        }

        for (int u = 0; u < l; u++) {
            arr[i + u] = q[u];
        }
    }

    void Swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

}
