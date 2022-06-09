package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

public class LowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        boolean isLeft = findNode(root.left, p, q);
        boolean isRight = findNode(root.right, p, q);
        if (isLeft && isRight) {
            return root;
        }
        return isLeft ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
    }

    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root == p || root == q) {
            return true;
        }
        return findNode(root.left, p, q) || findNode(root.right, p, q);
    }



}
