package com.yochiu.algorithms.code_interviews;

/**
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */

public class SearchNum {

    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (target == num) {
                count++;
            }
        }
        return count;
    }

}
