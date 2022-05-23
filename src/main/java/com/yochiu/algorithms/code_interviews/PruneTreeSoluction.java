package com.yochiu.algorithms.code_interviews;


import com.yochiu.algorithms.code_interviews.data.TreeNode;

public class PruneTreeSoluction {


    public TreeNode pruneTree(TreeNode root) {
        TreeNode node = root;
        boolean isClean = pruneTree2(node);
        return isClean ? null : root;
    }


    public boolean pruneTree2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isCleanLeft = pruneTree2(root.left);
        boolean isCleanRight = pruneTree2(root.right);
        if (isCleanLeft) {
            root.left = null;
        }
        if (isCleanRight) {
            root.right = null;
        }
        return isCleanLeft && isCleanRight && root.val == 0;
    }




}
