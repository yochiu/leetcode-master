package com.yochiu.algorithms.code_interviews;

import java.util.LinkedList;

public class MovingAverage {

    private int size;
    private LinkedList<Integer> queue;
    private int sum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() < size) {
            queue.add(val);
        } else {
            int pollFirst = queue.pollFirst();
            queue.add(val);
            sum -= pollFirst;
        }
        sum += val;
        return sum / (double) queue.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
