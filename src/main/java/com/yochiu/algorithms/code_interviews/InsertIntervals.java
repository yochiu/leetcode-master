package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 *
 */
public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> array = new ArrayList<>(Arrays.asList(intervals));
        array.add(newInterval);
        array.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> newArray = new ArrayList<>();
        newArray.add(array.get(0));
        for (int i = 1; i < array.size(); i++) {
            int[] cur = array.get(i);
            int[] p = newArray.get(newArray.size() - 1);
            if (p[1] < cur[0]) {
                newArray.add(cur);
            } else {
                p[0] = Math.min(p[0], cur[0]);
                p[1] = Math.max(p[1], cur[1]);
            }
        }

        return newArray.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        InsertIntervals insertIntervals = new InsertIntervals();
        int[][] res = insertIntervals.insert(new int[][]{
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        }, new int[]{4, 8});
        System.out.println("--");
    }

}
