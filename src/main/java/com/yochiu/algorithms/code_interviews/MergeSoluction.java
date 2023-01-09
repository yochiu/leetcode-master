package com.yochiu.algorithms.code_interviews;


import java.util.*;

public class MergeSoluction {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (res.size() == 0) {
                res.add(intervals[i]);
                continue;
            }
            int[] last = res.get(res.size() - 1);
            if (intervals[i][0] <= last[1]) {
                last[1] = intervals[i][1];
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public void quickSort(int[][] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = arr[low][0], i = low, j = high, k = arr[low][1];
        while (i < j) {
            while (arr[j][0] >= p && i < j) {
                j--;
            }
            while(arr[i][0] <= p && i < j) {
                i++;
            }

            int[][] tmp = new int[1][1];
            tmp[0][0] = arr[j][0];
            tmp[0][1] = arr[j][1];

            arr[j][0] = arr[i][0];
            arr[j][1] = arr[i][1];

            arr[i][0] = tmp[0][0];
            arr[i][1] = tmp[0][1];
        }

        arr[low][0] = arr[i][0];
        arr[low][1] = arr[j][1];
        arr[i][0] = p;
        arr[i][1] = k;
        quickSort(arr, low,j - 1);
        quickSort(arr,j + 1, high);
    }

    public static void quickSort(int[] arr,int low,int high) {
        if(low >= high) {
            return;
        }
        int p = arr[low], i = low, j = high;
        int temp;
        while(i < j) {
            while(arr[j] >= p && i < j) {
                j--;
            }
            while(arr[i] <= p && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low,j - 1);
        quickSort(arr,j + 1, high);

    }


}
