package com.yochiu.algorithms.code_interviews;

import org.codehaus.groovy.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        int i = 0;
        StringBuffer stringBuilder = new StringBuffer();
        while (i < array.length) {
            while (i < array.length && array[i] == ' ') {
                if (stringBuilder.length() > 0) {
                    res.add(stringBuilder.toString());
                    stringBuilder = new StringBuffer();
                }
                i++;
            }
            if (i >= array.length) {
                break;
            }
            stringBuilder.append(array[i++]);
        }
        if (stringBuilder.length() > 0) {
            res.add(stringBuilder.toString());
        }
        StringBuffer newString = new StringBuffer();
        for (int j = res.size() - 1; j >= 0; j--) {
            if (j == 0) {
                newString.append(res.get(j));
            } else {
                newString.append(res.get(j)).append(" ");
            }
        }
        return newString.toString();
    }


    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("  hello world!  "));
    }


}
