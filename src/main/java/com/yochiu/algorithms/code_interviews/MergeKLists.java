package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

import java.util.Collections;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0 , lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeKLists(lists, left, mid);
        ListNode rightList = mergeKLists(lists, mid+ 1, right);
        return mergeList(leftList, rightList);
    }

    public ListNode mergeList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head = new ListNode(-1);
        ListNode node = head;
        ListNode p1 = a, p2 = b;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null && p1.val < p2.val) {
                node.next = p1;
                p1 = p1.next;
            } else if (p1 != null && p2 != null) {
                node.next = p2;
                p2 = p2.next;
            } else if (p1 == null) {
                node.next = p2;
                p2 = p2.next;
            }else {
                node.next = p1;
                p1 = p1.next;
            }
            node = node.next;
        }
        return head.next;
    }
}
