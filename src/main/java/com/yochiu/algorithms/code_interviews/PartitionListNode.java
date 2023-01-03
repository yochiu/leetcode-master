package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

/**

 *
 * head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * head = [2,1], x = 2
 * 输出：[1,2]
 */

public class PartitionListNode {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1), right = new ListNode(-1);
        ListNode p = left, q = right, cur= head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = null;
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur = tmp;
        }
        p.next = right.next;
        return left.next;
    }
}
