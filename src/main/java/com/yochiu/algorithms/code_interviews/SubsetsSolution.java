package com.yochiu.algorithms.code_interviews;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * https://leetcode.cn/problems/subsets/
 */
public class SubsetsSolution {

    public static void main(String[] args) {
        SubsetsSolution subsetsSolution = new SubsetsSolution();
        List<List<Integer>> res = subsetsSolution.subsets(new int[]{1, 2, 3});
        System.out.println("------");
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = split(nums, 0, nums.length - 1);
        res.add(new ArrayList<>());
        return res;
    }

    public List<List<Integer>> split(int[] nums, int left, int right) {
        if (left >= right) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> items = new ArrayList<>();
            items.add(nums[left]);
            res.add(items);
            return res;
        }
        int mid = left + (right - left) / 2;
        List<List<Integer>> leftArray = split(nums, left, mid);
        List<List<Integer>> rightArray = split(nums, mid + 1, right);
        List<List<Integer>> resArray = new ArrayList<>();
        resArray.addAll(leftArray);
        resArray.addAll(rightArray);
        for (List<Integer> leftItems : leftArray) {
            for (List<Integer> rightItems : rightArray) {
                List<Integer> combinationItems = new ArrayList<>();
                combinationItems.addAll(leftItems);
                combinationItems.addAll(rightItems);
                resArray.add(combinationItems);
            }
        }

        return resArray;
    }
}
