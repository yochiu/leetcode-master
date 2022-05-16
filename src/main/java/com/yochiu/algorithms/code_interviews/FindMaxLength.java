package com.yochiu.algorithms.code_interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1：
 * 输入: nums = [0,1]
 * 输出: 2

 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        for (int i = 0; i< nums.length; i++) {
            sum+=nums[i];
            if (map.containsKey(sum)) {
                int preIndex = map.get(sum);
                len = Math.max(len, i - preIndex);
            } else {
                map.put(sum, i );
            }
        }
        return len;
    }

    public static void main(String[] args) {
        FindMaxLength findMaxLength = new FindMaxLength();
        System.out.println(findMaxLength.findMaxLength(new int[]{0,1}));
    }

}
