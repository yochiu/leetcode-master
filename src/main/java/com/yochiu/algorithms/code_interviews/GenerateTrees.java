package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * 给你一个整数n ，请你生成并返回所有由n个节点组成且节点值从1到n互不相同的不同二叉搜索树
 * 可以按 任意顺序 返回答案。
 *
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/
 */


public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; i ++) {
            List<TreeNode> leftNodes = generateTrees(start, i -1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);

            for (TreeNode leftNode: leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    treeNodes.add(node);
                }
            }
        }

        return treeNodes;
    }



}
