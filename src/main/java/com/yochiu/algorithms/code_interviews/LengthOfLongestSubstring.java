package com.yochiu.algorithms.code_interviews;

import org.codehaus.groovy.util.StringUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int left = 0, right = 0;
        while (right < array.length) {
            if (!map.containsKey(array[right])) {
                len = Math.max(right - left + 1, len);
            } else {
                if (map.get(array[right]) < left) {
                    len = Math.max(right - left + 1, len);
                } else {
                    len = Math.max(right - map.get(array[right]), len);
                    left = map.get(array[right]) + 1;
                }
            }
            map.put(array[right], right);
            right++;
        }
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int right = 0, len = 0, i = 0;
        while (i < array.length) {
            while (set.contains(array[i])) {
                set.remove(array[right]);
                right++;
            }
            set.add(array[i]);
            len = Math.max(i - right + 1, len);
            i++;
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring soluction = new LengthOfLongestSubstring();
        System.out.println(soluction.lengthOfLongestSubstring2("abcd"));
        System.out.println(soluction.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(soluction.lengthOfLongestSubstring2("bbbbbbbb"));
        System.out.println(soluction.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(soluction.lengthOfLongestSubstring2(""));
        System.out.println(soluction.lengthOfLongestSubstring2(" "));
        System.out.println(soluction.lengthOfLongestSubstring2("tmmzuxt"));
    }

}

