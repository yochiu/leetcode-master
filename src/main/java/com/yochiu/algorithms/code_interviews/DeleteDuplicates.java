package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次
 * 返回已排序的链表
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 删除排序链表中的重复元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            while (next != null && node.val == next.val) {
                next = next.next;
            }
            node.next = next;
            node = next;
        }
        return head;
    }

}
