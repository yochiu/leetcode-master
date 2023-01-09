package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> res = subsetsWithDup.subsetsWithDup(new int[]{1,2,2});
        System.out.println("---");
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        subsetsWithDup(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void subsetsWithDup(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDup(i + 1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }

}
