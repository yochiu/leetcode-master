package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

import java.util.List;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL

 */
public class Linked2Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node != null && node.next != null) {
            node = node.next;
        }
        reverse(head);
        return node;
    }

    public void reverse(ListNode node) {
        if (node.next == null) {
            return;
        }
        ListNode next = node.next;
        reverse(next);
        next.next = node;
        node.next = null;
    }
}
