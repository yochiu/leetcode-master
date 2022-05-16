package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.List;

public class ShoffeeSolution {

    public void findMax(int[] nums, int k) {
        List<Integer> lessThanKArray = new ArrayList<>();
        List<Integer> moreThanKArray = new ArrayList<>();
        for (int num : nums) {
            if (num < k) {
                lessThanKArray.add(num);
            } else {
                moreThanKArray.add(num);
            }
        }




    }
}
