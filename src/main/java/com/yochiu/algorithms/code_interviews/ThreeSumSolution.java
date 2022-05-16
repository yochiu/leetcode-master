package com.yochiu.algorithms.code_interviews;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        ThreeSumSolution solution = new ThreeSumSolution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
