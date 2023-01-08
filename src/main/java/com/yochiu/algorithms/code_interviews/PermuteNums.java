package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 链接：https://leetcode.cn/problems/permutations
 */
public class PermuteNums {

    public static void main(String[] args) {
        PermuteNums permuteNums = new PermuteNums();
        List<List<Integer>> res = permuteNums.permute(new int[]{1,2,3});
        System.out.println("---");
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(new boolean[nums.length], nums, new ArrayList<>(), res);
        return res;
    }

    public void permute(boolean[] used, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                permute(used, nums, path, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

}
