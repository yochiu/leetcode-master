package com.yochiu.algorithms.code_interviews;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:

 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {

    private Stack<Integer> addStack;

    private Stack<Integer> minStack;

    public MinStack() {
        this.addStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        addStack.add(x);
        if (minStack.isEmpty()) {
            minStack.add(x);
        } else {
            minStack.add(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        addStack.pop();
        minStack.pop();
    }

    public int top() {
        return addStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
