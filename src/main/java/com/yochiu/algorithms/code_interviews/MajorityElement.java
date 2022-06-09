package com.yochiu.algorithms.code_interviews;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i : nums) {
           map.put(i, map.getOrDefault(i, 0) + 1);
           if (map.get(i) >= nums.length / 2) {
               return i;
           }
       }
        return 0;
    }

}