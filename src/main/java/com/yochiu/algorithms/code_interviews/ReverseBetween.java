package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }

        ListNode emptyNode = new ListNode(Integer.MAX_VALUE, head);
        ListNode p = emptyNode;
        ListNode leftLastNode = null;
        int a = 0;
        while (p != null) {
            if (a == left) {
                break;
            }
            a++;
            leftLastNode = p;
            p = p.next;
        }

        ListNode midLast = p;
        ListNode prev = null;
        while (p != null && a != right) {
            a++;
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }

        ListNode rightFirstNode = p.next;
        p.next = prev;

        leftLastNode.next = p;
        midLast.next = rightFirstNode;
        return emptyNode.next;
    }

}
