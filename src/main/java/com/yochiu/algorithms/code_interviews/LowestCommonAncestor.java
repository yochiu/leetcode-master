package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }



}
