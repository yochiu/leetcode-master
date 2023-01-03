package com.yochiu.algorithms.code_interviews;

import org.codehaus.groovy.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {

    char[][] array = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        char[] digitsArray = digits.toCharArray();
        List<String> res = new ArrayList<>();
        letterCombinations(digitsArray, 0, "", res);
        return res;
    }

    public void letterCombinations(char[] digitsArray, int index, String s, List<String> res) {
        if (index == digitsArray.length) {
            res.add(s);
            return;
        }
        int arrayIndex = digitsArray[index] - '2';
        char[] chars = array[arrayIndex];
        for (char c : chars) {
            letterCombinations(digitsArray, index + 1, s+c, res);
        }
    }


    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> res = letterCombinations.letterCombinations("23");
        System.out.println(res);

        List<String> res1 = letterCombinations.letterCombinations("");
        System.out.println(res1);
    }

}
