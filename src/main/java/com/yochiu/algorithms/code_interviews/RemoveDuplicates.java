package com.yochiu.algorithms.code_interviews;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int p = 0, i = 0;
        while (i  < nums.length) {
            if (i + 1 < nums.length && nums[i+1] == nums[i]) {
                i++;
                continue;
            }
            nums[p++] = nums[i++];
        }
        return p;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates.removeDuplicates(new int[]{1, 2, 3}));
    }
}
