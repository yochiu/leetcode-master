package com.yochiu.algorithms.code_interviews;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1
 * 输入：
 *      ["CQueue","appendTail","deleteHead","deleteHead"]
 *      [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 */
public class CQueue {

    private Stack<Integer> addStack;

    private Stack<Integer> popStack;

    public CQueue() {
        this.addStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void appendTail(int value) {
        this.addStack.add(value);
    }

    public int deleteHead() {
        if (!popStack.isEmpty()) {
            return popStack.pop();
        }
        while (!addStack.isEmpty()) {
            popStack.add(addStack.pop());
        }
        return popStack.isEmpty() ? -1 : popStack.pop();
    }

}
