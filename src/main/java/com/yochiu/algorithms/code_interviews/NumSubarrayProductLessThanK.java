package com.yochiu.algorithms.code_interviews;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            int i = left;
            int preSum = nums[i];
            while (i < right) {
                if (preSum < k) {
                    count++;
                } else {
                    left++;
                    break;
                }
                preSum *= nums[i];
                i++;
            }
            right++;
        }
        return count;
    }


    public static void main(String[] args) {
        NumSubarrayProductLessThanK soluction = new NumSubarrayProductLessThanK();
        System.out.println(soluction.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(soluction.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(soluction.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));

    }

}
