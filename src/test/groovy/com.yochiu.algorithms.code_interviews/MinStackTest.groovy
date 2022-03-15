package com.yochiu.algorithms.code_interviews

import spock.lang.Specification

class MinStackTest extends Specification{

    MinStack minStack = new MinStack();

    def 'minStackTest'() {
        given: 'add data'
        minStack.push(-3)
        minStack.push(0)
        minStack.push(-2);

        when: 'get data'
        def data1 = minStack.min()
        def data2 = minStack.top();
        def data3 = minStack.min()
        def data4 = minStack.min()

        then: 'data verify'
        data1 == -3
        data2 == -2
        data3 == -3
        data4 == -3
    }

}
