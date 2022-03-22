package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 */
public class LinkedSolution {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        reverse(head, res);
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }
        return array;
     }

     public void reverse(ListNode head, List<Integer> res) {
        if (head == null) {
            return;
        }
        reverse(head.next, res);
        res.add(head.val);
     }

}
