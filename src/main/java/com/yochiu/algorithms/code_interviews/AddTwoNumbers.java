package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = reverseList(l1);
        ListNode p2 = reverseList(l2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int a = 0;
        while (p1 != null || p2 != null) {
            int val1 = p1 == null ? 0 : p1.val;
            int val2 = p2 == null ? 0 : p2.val;
            int val = val1 + val2;
            int b = (val + a) % 10;
            a = val / 10;
            ListNode node = new ListNode(b);
            cur.next = node;
            cur = node;
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }
        return head.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = p;
            p = head;
            head = next;
        }
        return p;
    }
}
