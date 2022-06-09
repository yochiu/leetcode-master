package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PathSum {

    private int a = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pollFirst();
            pathSum(node, targetSum, 0);
            if (node.left != null) {
                linkedList.add(node.left);
            }
            if (node.right != null) {
                linkedList.add(node.right);
            }
        }
        return a;
    }

    public void pathSum(TreeNode root, int targetSum, int curSum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        if (curSum == targetSum) {
            a++;
        }
        pathSum(root.left, targetSum, curSum);
        pathSum(root.right, targetSum, curSum);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return bfs(root, map, targetSum, 0);
    }

    public int bfs(TreeNode root, Map<Integer, Integer> map, int targetSum, int sum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int diff = sum - targetSum;
        int count = map.getOrDefault(diff, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += bfs(root.left, map, targetSum, sum);
        count += bfs(root.right, map, targetSum, sum);
        map.put(sum, map.getOrDefault(sum, 0 ) - 1);
        return count;
    }

}
