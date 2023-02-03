package com.yochiu.algorithms.code_interviews;

/**
 * 给你两个按非递减顺序排列的整数数组nums1和nums2
 * 另有两个整数m和n, 分别表示nums1和nums2中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素
 *
 * 合并两个有序数组
 */
public class Merge {


    /**
     * nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 1) {

        }
        int p1 = 0, p2 = 0;
        while (p1 < m) {
            while (nums1[p1] <= nums1[p2]) {
                p1++;
            }
            int a = nums1[p1];
            int p3 = p1, p4 = p2;
            while (p4 < n && nums2[p4] < a) {
                int tmp = nums1[p3];
                nums1[p3] = nums2[p4];
                nums2[p4] = tmp;
                p4++;
                p3++;
            }
            p1++;
        }
        while (p1 < nums1.length) {
            nums1[p1++] = nums2[p2++];
        }

        System.out.println("---");
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n -1, p = nums1.length - 1;
        while (p >= 0) {
            if (p1 == -1) {
                nums1[p--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[p--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        //merge.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge.merge2(new int[]{1,3,6,8,0,0}, 4, new int[]{4,9}, 2);
    }



}
