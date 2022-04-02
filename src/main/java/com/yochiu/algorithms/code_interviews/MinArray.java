package com.yochiu.algorithms.code_interviews;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1

 */
public class MinArray {

    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (numbers[mid] < numbers[right]){
                right = mid;
            } else if (numbers[mid] == numbers[right]){
                right--;
            } else {
                left++;
            }
        }
        return numbers[left];
    }

    public static int minArray2(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[r] > numbers[mid]) {
                r = mid;
            } else if (numbers[r] < numbers[mid]) {
                l = mid + 1;
                //去重
            } else r--;
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,3,1,3};
        System.out.println(minArray(array));
        int[] array1 = new int[]{10,1,10,10,10};
        System.out.println(minArray(array1));
        int[] array2 = new int[]{2,2,2,2,1,2,2};
        System.out.println(minArray2(array2));
    }
}
