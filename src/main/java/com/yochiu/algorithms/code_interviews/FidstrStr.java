package com.yochiu.algorithms.code_interviews;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1
 *
 */
public class FidstrStr {

    public int strStr(String haystack, String needle) {
        char[] hayStackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i <= hayStackChars.length - needleChars.length; i++) {
            if (hayStackChars[i] == needleChars[0]) {
                int k = 0;
                for (int j = i; j < i + needleChars.length && hayStackChars[j] == needleChars[k]; j++) {
                    k++;
                }
                if (k == needleChars.length) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FidstrStr fidstrStr = new FidstrStr();
        System.out.println(fidstrStr.strStr("sadbutsad", "sad"));
        System.out.println(fidstrStr.strStr("leetcode", "leeto"));
        System.out.println(fidstrStr.strStr("sadbutsad", "but"));
    }
}
