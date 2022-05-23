package com.yochiu.algorithms.code_interviews;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int i = Math.min(left, right);
        for (; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
        }
        return Math.max(i, 0);
    }

    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        //System.out.println(searchInsert.searchInsert(new int[]{1, 2}, 1));
        //System.out.println(searchInsert.searchInsert(new int[]{1, 2}, 2));
        //System.out.println(searchInsert.searchInsert(new int[]{1,2,3,4,5,6}, 5));
        //System.out.println(searchInsert.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert.searchInsert2(new int[]{1, 3, 5, 6}, 7));
    }
}
