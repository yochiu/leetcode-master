package com.yochiu.algorithms.code_interviews.data;

public class Node {

    public int val;
    public Node next;
    public Node random;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

}
