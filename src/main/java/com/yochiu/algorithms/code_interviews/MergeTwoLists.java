package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            ListNode a = new ListNode(Math.min(l1.val, l2.val));
            node.next = a;
            node = a;
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            ListNode a = new ListNode(l1.val);
            node.next = a;
            node = a;
        }
        while (l2 != null) {
            ListNode a = new ListNode(l2.val);
            node.next = a;
            node = a;
        }
        return head.next;
    }
}
