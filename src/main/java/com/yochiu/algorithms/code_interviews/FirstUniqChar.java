package com.yochiu.algorithms.code_interviews;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'

 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (array[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("abaccdeff"));
    }
}
