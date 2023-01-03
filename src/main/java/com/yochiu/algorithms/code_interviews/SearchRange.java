package com.yochiu.algorithms.code_interviews;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                int l = mid, r = mid;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (r < nums.length && nums[r] == target) {
                    r++;
                }
                return new int[]{l == -1 && nums[0] == target ? 0 : l + 1, r-1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();

        int[] res = searchRange.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(res[0] + "  " + res[1]);

        int[] res1 = searchRange.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(res1[0] + "  " + res1[1]);

        int[] res2 = searchRange.searchRange(new int[]{}, 0);
        System.out.println(res2[0] + "    " + res2[1]);

        int[] res3 = searchRange.searchRange(new int[]{6}, 6);
        System.out.println(res3[0] + "    " + res3[1]);

        int[] res4 = searchRange.searchRange(new int[]{5,6}, 5);
        System.out.println(res4[0] + "    " + res4[1]);

        int[] res5 = searchRange.searchRange(new int[]{1}, 1);
        System.out.println(res5[0] + "    " + res5[1]);

        int[] res6 = searchRange.searchRange(new int[]{2,2}, 2);
        System.out.println(res6[0] + "    " + res6[1]);
    }


}
