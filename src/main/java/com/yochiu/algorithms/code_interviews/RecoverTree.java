package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.*;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 */
public class RecoverTree {

    public void recoverTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        askTree(root, res);
        List<Integer> copyRes = new ArrayList<>(res);
        res.sort(Comparator.comparingInt(o -> o));
        List<Integer> errorNums = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) != copyRes.get(i)) {
                errorNums.add(res.get(i));
            }
        }
        int num1 = errorNums.get(0), num2 = errorNums.get(1);
        TreeNode node1 = findTreeNode(root, num1);
        TreeNode node2 = findTreeNode(root, num2);

        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;

    }

    public TreeNode findTreeNode(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        TreeNode left = findTreeNode(node.left, val);
        if (left != null) {
            return left;
        }
        TreeNode right = findTreeNode(node.right, val);
        if (right != null) {
            return right;
        }
        return null;
    }

    public void askTree(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            askTree(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            askTree(node.right, res);
        }

    }



}
