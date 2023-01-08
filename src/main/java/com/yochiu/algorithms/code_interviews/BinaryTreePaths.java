package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点
 *
 * https://leetcode.cn/problems/binary-tree-paths/
 */

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        searchTreePaths(root, "", res);
        return res;
    }

    public void searchTreePaths(TreeNode node, String s, List<String> res) {
       if (node == null) {
           return;
       }
       if (node.left == null && node.right == null) {
           res.add(s + node.val);
           return;
       }
       searchTreePaths(node.left, s + node.val + "->", res);
       searchTreePaths(node.right, s + node.val + "->", res);
    }


}
