package com.yochiu.algorithms.code_interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是[1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 最长连续子序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
 *
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int a = longestConsecutive.longestConsecutive(new int[]{100,4,200,1,3,2});
        int b = longestConsecutive.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        int c = longestConsecutive.longestConsecutive(new int[]{1});
        int d = longestConsecutive.longestConsecutive(new int[]{1,2,0,1});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    /**
     * 时间复杂度O(logn*n)
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, max = 1;
        while (i < nums.length) {
            int len = 0;
            while (i < nums.length - 1 && (nums[i+1] == nums[i]+1 || nums[i+1] == nums[i])) {
                if (nums[i+1] == nums[i]) {
                    while (i < nums.length - 1 && nums[i+1] == nums[i]) {
                        i++;
                    }
                } else {
                    len++;
                    i++;
                }
            }
            max = Math.max(len + 1, max);
            i++;
        }
        return max;
    }

    /**
     * 时间复杂度O(n)
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


}
