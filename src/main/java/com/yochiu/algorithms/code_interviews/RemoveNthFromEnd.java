package com.yochiu.algorithms.code_interviews;

import com.yochiu.algorithms.code_interviews.data.ListNode;
import jdk.nashorn.internal.ir.SplitReturn;
import org.codehaus.groovy.ast.expr.SpreadExpression;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int k = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            k++;
        }
        node = new ListNode(0, head);
        ListNode cur = node;
        int p = 1;
        while ( p < n - k + 1) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return node.next;
    }

}
