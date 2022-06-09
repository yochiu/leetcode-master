package com.yochiu.algorithms.code_interviews;

public class PrintNumbers {

    public int[] printNumbers(int n) {
        int a = (int ) Math.pow(10, n) - 1;
        int[] res = new int[a];
        for (int i = 1; i <= a; i++) {
            res[i-1] = i;
        }
        return res;
    }


}
