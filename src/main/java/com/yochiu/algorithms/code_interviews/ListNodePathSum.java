package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点
 *
 * 链接：https://leetcode.cn/problems/path-sum-ii
 */
public class ListNodePathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, 0, path, res);
        return res;
    }

    public void pathSum(TreeNode node, int targetSum, int sum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        sum+=node.val;
        path.add(node.val);
        if (sum == targetSum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }
        pathSum(node.left, targetSum, sum, path, res);
        pathSum(node.right, targetSum, sum, path, res);
        path.remove(path.size()-1);
    }
}
