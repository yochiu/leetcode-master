package com.yochiu.algorithms.code_interviews

import com.yochiu.algorithms.code_interviews.data.ListNode
import spock.lang.Specification

class LinkedSolutionTest extends Specification{

    LinkedSolution solution = new LinkedSolution()

    def 'test'() {
        given: 'add data'
        ListNode head = new ListNode(1)
        ListNode node1 = new ListNode(2)
        ListNode node2 = new ListNode(3)
        head.next = node1
        node1.next = node2

        when: 'get data'
        int[] array = solution.reversePrint(head)

        then: 'verify data'
        array.length == 3
        array[0] == 3
        array[1] == 2
        array[2] == 1
    }


}
