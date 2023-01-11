package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode(-1);
        empty.next = head;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        node = empty;
        int cur = 0, k = len - n;
        while (cur < k) {
            node = node.next;
            cur++;
        }
        node.next = node.next.next;
        return empty.next;
    }
}
