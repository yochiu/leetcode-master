package com.yochiu.algorithms.code_interviews;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        int size = s.length();
        if (n >= size) {
            return s;
        }
        String left = s.substring(0, n);
        String right = s.substring(n);
        return right + left;
    }

}
