package com.yochiu.algorithms.code_interviews;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSoluction {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                left--;
            } else if (sum < target) {
                right++;
            } else {
                return new int[]{left,right};
            }
        }
        return null;
    }

}
