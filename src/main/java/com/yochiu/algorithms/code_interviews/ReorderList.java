package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

import java.util.Stack;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node);
            node = node.next;
        }
        node = head;
        do {
            ListNode last =  stack.pop();
            if (last == node) {
                break;
            }
            if (node.next == last) {
                last.next = null;
                break;
            }
            ListNode next = node.next;
            node.next = last;
            node = next;
            last.next = node;
        } while (!stack.isEmpty());
    }
}
