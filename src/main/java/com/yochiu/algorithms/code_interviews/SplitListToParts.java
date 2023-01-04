package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * 返回一个由上述 k 部分组成的数组。
 *
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 *
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 *
 * https://leetcode.cn/problems/split-linked-list-in-parts
 */
public class SplitListToParts {

    public ListNode[] splitListToParts(ListNode head, int x) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        int subLen = len / x;
        int k = len % x;

        ListNode cur = head;
        int count = 0;
        List<ListNode> array = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            ListNode p = cur;
            for (int j = 0; j < subLen; j++) {
                p = p.next;
            }
            if (count++ < k) {
                p = p.next;
            }
            array.add(cur);
            cur = p;
        }

        return array.toArray(new ListNode[]{});
    }
}
