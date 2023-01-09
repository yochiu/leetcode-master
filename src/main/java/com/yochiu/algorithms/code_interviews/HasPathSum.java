package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点
 *
 * https://leetcode.cn/problems/path-sum
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    public boolean hasPathSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (sum == targetSum && node.left == null && node.right == null) {
            return true;
        }
        return hasPathSum(node.left, sum, targetSum) || hasPathSum(node.right, sum, targetSum);
    }

}
