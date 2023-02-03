package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 三角形的最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));
        List<Integer> pre = dp.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> nums = triangle.get(i);
            List<Integer> next = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if (j== 0) {
                    next.add(pre.get(j) + nums.get(j));
                } else if (j == nums.size() - 1) {
                    next.add(pre.get(j -1) + nums.get(j));
                } else {
                    next.add(Math.min(pre.get(j) + nums.get(j), pre.get(j-1) + nums.get(j)));
                }
            }
            dp.add(next);
            pre = next;
        }
        List<Integer> last = dp.get(dp.size() - 1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < last.size(); i++) {
            min = Math.min(min, last.get(i));
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);


        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        res.add(list);
        res.add(list1);
        res.add(list3);
        res.add(list4);

        minimumTotal.minimumTotal(res);
    }

}
