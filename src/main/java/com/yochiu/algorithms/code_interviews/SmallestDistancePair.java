package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回所有数对距离中第k小的数对距离。
 * 示例 1：
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0
 *
 * 通过测试用例：
 * 6 / 19
 * 输入：
 * [9,10,7,10,6,1,5,4,9,8]
 * 18
 * 输出：
 * 4
 * 预期结果：
 * 2
 */
public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        smallestDistancePair(nums, 0, res);
        res.sort(Comparator.comparingInt(o -> o));
        return res.get(k-1);
    }

    public void smallestDistancePair(int[] nums, int startIndex, List<Integer> res) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex + 1; i < nums.length; i++) {
            res.add(Math.abs(nums[i] - nums[startIndex]));
        }
        smallestDistancePair(nums, startIndex + 1, res);
    }

    public static void main(String[] args) {
        SmallestDistancePair sp = new SmallestDistancePair();
       /* System.out.println(sp.smallestDistancePair2(new int[]{1,3,1}, 1));
        System.out.println(sp.smallestDistancePair2(new int[]{1,1,1}, 2));
        System.out.println(sp.smallestDistancePair2(new int[]{1,6,1}, 3));*/
        System.out.println(sp.smallestDistancePair2(new int[]{9,10,7,10,6,1,5,4,9,8}, 18));
    }

    public int smallestDistancePair2(int[] nums, int k) {
        int[] arr = new int[nums.length-1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = Math.abs(nums[i+1] - nums[i]);
        }
        return find(arr, k, 0, 0);
    }

    public int find(int[] arr, int k, int c, int dif) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length - dif; i++) {
            int sum = arr[i];
            for (int j = i + 1; j <= i + dif && j < arr.length; j++) {
                sum+=arr[j];
            }
            res.add(sum);
        }
        res.sort(Comparator.comparingInt(o -> o));
        int a = k - c;
        if (a <= res.size()) {
            return res.get(a-1);
        }
        return find(arr, k, c + res.size(), dif +1);
    }


    // 1 4 5 6 7 8 9 9 10 10
    //  3 1 1 1 1 1 0 1 0   9
    //   4 2 2 2 2 1 1 1    8
    //    5 3 3 2 2 2 1
}
