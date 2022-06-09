package com.yochiu.algorithms.code_interviews;

import java.util.LinkedList;

public class MaxQueue {

    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> maxQueue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int frontNum =  queue.pollFirst();
        if (frontNum == maxQueue.peekFirst()) {
            maxQueue.pollFirst();
        }
        return frontNum;
    }

}
