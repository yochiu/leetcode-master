package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntervalsMerge {

    public int[][] merge(int[][] intervals) {
        List<int[]> intervalsList = Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());

        List<int[]> res = new ArrayList<>();
        int[] preNums = intervalsList.get(0);
        for (int i = 1; i< intervals.length; i++) {
            int[] curNums = intervalsList.get(i);
            if (preNums[1] < curNums[0]) {
                res.add(preNums);
                preNums = curNums;
            } else {
                int[] newNums = new int[2];
                newNums[0] = preNums[0];
                if (preNums[1] <= curNums[1]) {
                    newNums[1] = curNums[1];
                } else {
                    newNums[1] = preNums[1];
                }
                preNums = newNums;
            }
        }
        res.add(preNums);
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        IntervalsMerge intervalsMerge = new IntervalsMerge();

        int[][] res = intervalsMerge.merge(new int[][]{
                {1,3},
                {8,10},
                {2,6},
                {15,18}
        });

        int[][] res1 = intervalsMerge.merge(new int[][]{
                {1,4},
                {4,5}
        });

        System.out.println("-----");

    }

}
