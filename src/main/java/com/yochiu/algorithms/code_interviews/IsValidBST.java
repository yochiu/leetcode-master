package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        readNode(root, res);
        for (int i = 0; i <res.size() - 1; i++) {
            if (res.get(i+1) < res.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void readNode(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        readNode(node.left, res);
        res.add(node.val);
        readNode(node.right, res);
    }


}
