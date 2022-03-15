package com.yochiu.algorithms.code_interviews

import spock.lang.Specification

class CQueueTest extends Specification {

    CQueue cQueue = new CQueue();

    def 'cQueueTest'() {
        given: 'add data'
        cQueue.appendTail(1)
        cQueue.appendTail(5)

        when: 'get data'
        def data1 = cQueue.deleteHead()
        def data2 = cQueue.deleteHead()
        def data3 = cQueue.deleteHead()

        then: 'data verify'
        data1 == 1
        data2 == 5
        data3 == 0
    }

}
