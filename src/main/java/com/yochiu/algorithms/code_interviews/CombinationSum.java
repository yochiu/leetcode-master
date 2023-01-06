package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个无重复元素的整数数组candidates 和一个目标整数target
 * 找出candidates中可以使数字和为目标数target的所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 *
 * https://leetcode.cn/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> res = combinationSum.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println("-------");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(0, candidates, new ArrayList<>(), 0, target, res);
        return res;
    }

    public void combinationSum(int start, int[] candidates, List<Integer> path, int sum, int target, List<List<Integer>> res) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            combinationSum(i, candidates, path, sum + candidates[i], target, res);
            path.remove(path.size() - 1);
        }
    }

}
