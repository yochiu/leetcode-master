package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

public class ReverseList {

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
