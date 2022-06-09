package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.Node;

public class TreeToDoublyList {

    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node tail =  treeToDoublyList(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}
