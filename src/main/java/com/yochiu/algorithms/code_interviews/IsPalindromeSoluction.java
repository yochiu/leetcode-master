package com.yochiu.algorithms.code_interviews;

public class IsPalindromeSoluction {

    public boolean isPalindrome(String s) {
        char[] array = s.toLowerCase().toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (!((array[left] >= 'a' && array[right] <= 'z') || array[left] >= '0' && array[left]<= '9') && left < right) {
                left++;
            }
            while (!((array[right] >= 'a' && array[right] <= 'z') || array[right] >= '0' && array[right]<= '9') && left < right) {
                right--;
            }
            if (array[left++] != array[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeSoluction soluction = new IsPalindromeSoluction();
        System.out.println(soluction.isPalindrome("race a car"));
        System.out.println(soluction.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
