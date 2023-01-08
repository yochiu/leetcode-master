package com.yochiu.algorithms.code_interviews;

import java.util.*;

/**
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 题解:https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-ga-4/
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("aab");
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] array = s.toCharArray();
        Arrays.sort(array);
        permutation(used, array, "", res);
        return res.toArray(new String[]{});
    }

    public void permutation(boolean[] used, char[] array, String s, List<String> res) {
        if (s.length() == array.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i-1] && used[i-1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                permutation(used, array,  s + array[i], res);
                used[i] = false;
            }
        }
    }
}
