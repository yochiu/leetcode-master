package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};

    }

    public static void main(String[] args) {
        SingleNumbers singleNumbers = new SingleNumbers();
        System.out.println(singleNumbers.singleNumbers(new int[]{4,1,4,6}).toString());
    }

}
