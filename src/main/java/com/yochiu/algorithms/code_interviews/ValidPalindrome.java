package com.yochiu.algorithms.code_interviews;

import org.codehaus.groovy.util.StringUtil;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] array = s.toCharArray();
        return validPalindrome(array, 0, s.length() - 1, false);
    }

    public boolean validPalindrome(char[] array, int left, int right, boolean mark) {
        if (left >= right) {
            return true;
        }
        if (array[left] == array[right]) {
            return validPalindrome(array, left + 1, right - 1, mark);
        }
        if (mark) {
            return false;
        }
        return validPalindrome(array, left + 1, right, true) || validPalindrome(array, left, right - 1, true);
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("aba"));
        System.out.println(validPalindrome.validPalindrome("abca"));
        System.out.println(validPalindrome.validPalindrome("abc"));
        System.out.println(validPalindrome.validPalindrome("aab"));
        System.out.println(validPalindrome.validPalindrome("eeccccbebaeeabebccceea"));
    }
}
