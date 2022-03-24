package com.yochiu.algorithms.code_interviews;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class SpaceSolution {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
