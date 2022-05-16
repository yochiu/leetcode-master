package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 */

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        /*初始化左边界 left = 0
        初始化返回值 ret = 最小值 or 最大值
        for 右边界 in 可迭代对象:
        更新窗口内部信息
        while 根据题意进行调整：
        比较并更新ret(收缩场景时)
        扩张或收缩窗口大小
        比较并更新ret(扩张场景时)
        返回 ret*/
        int left = 0;
        int ret = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ret = Math.min(ret, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen.minSubArrayLen(20, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{0, 3, 3, 1, 6}));
        System.out.println(minSubArrayLen.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen.minSubArrayLen(15, new int[]{5,1,3,5,10,7,4,9,2,8}));
    }


}
