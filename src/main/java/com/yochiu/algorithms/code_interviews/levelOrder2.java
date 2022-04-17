package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class levelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> tmpQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    tmpQueue.add(node.left);
                }
                if (node.right != null) {
                    tmpQueue.add(node.right);
                }
            }
            res.add(list);
            queue.addAll(tmpQueue);
        }
        return res;
    }

}
