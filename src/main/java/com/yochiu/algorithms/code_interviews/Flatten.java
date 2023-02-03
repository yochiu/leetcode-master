package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.TreeNode;

/**
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 二叉树展开链表
 * 展开后的单链表应该与二叉树先序遍历 顺序相同
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode last = root.left;
        root.left = null;
        if (last != null) {
            while (last.right != null) {
                last = last.right;
            }
            last.right = root.right;
            root.right = last;
        }
    }


}
