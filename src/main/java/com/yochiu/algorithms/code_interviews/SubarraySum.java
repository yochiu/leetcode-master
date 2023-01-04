package com.yochiu.algorithms.code_interviews;


import java.util.*;

public class SubarraySum {


    public int subarraySum(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            if (map.containsKey(diff)) {
                count += map.get(diff).size();
            }
            if (sum == k) {
                count++;
            }
            if (nums[i] == k &&  map.containsKey(diff) && !map.get(diff).contains(i - 1))  {
                count++;
            }
            Set<Integer> list = map.getOrDefault(sum, new HashSet<>());
            list.add(i);
            map.put(sum, list);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1}, 1));
        System.out.println(subarraySum.subarraySum(new int[]{1, 1 ,1}, 2));
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
    }
}
