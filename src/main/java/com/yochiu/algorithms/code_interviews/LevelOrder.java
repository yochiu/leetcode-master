package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> array = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> tmpQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.pollFirst();
                array.add(node.val);
                if (node.left != null) {
                    tmpQueue.add(node.left);
                }
                if (node.right != null) {
                    tmpQueue.add(node.right);
                }
            }
            queue.addAll(tmpQueue);
        }
        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }
        return res;
    }

}
