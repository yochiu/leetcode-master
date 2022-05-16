package com.yochiu.algorithms.code_interviews;

public class CountSubstringsSolution {

    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c[0]);
        for (int i = 1; i < c.length; i++) {
            stringBuilder.append('#').append(c[i]);
        }
        char[] chars = stringBuilder.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                count++;
            }
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                if (chars[left] != '#') {
                    count++;
                }
                left--;
                right++;
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int count = 0;
        for (int i = 0; i < ( 2 * n -1); i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < n && array[left--] == array[right++]) {
                count++;
            }
        }
        return count;
    }

    public int countSubstrings3(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int count = 0;
        for (int i = 0; i< n; i++) {
            int left = i, right = i;
            while (left >= 0 && right < n && array[left--] == array[right++]) {
                count++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && array[left--] == array[right++]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubstringsSolution solution = new CountSubstringsSolution();
        System.out.println(solution.countSubstrings3("abc"));
        System.out.println(solution.countSubstrings3("aaa"));
    }
}
