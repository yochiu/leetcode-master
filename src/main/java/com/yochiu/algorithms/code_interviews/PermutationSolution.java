package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 */
public class PermutationSolution {

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> res = new HashSet<>();
        permutation(chars, 0, res);
        return res.toArray(new String[]{});
    }

    public void permutation(char[] chars, int index, Set<String> res) {
        if (index >= chars.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(chars);
            res.add(stringBuilder.toString());
            return;
        }
        char indexChars = chars[index];
        for (int i = index; i < chars.length; i++){
            char iChar = chars[i];
            chars[index] = iChar;
            chars[i] = indexChars;
            permutation(chars, index+1, res);
            chars[index] = indexChars;
            chars[i] = iChar;
        }
    }

    public String[] permutation1(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }
    public void dfs(char[] arr, String s,  boolean[] visited, Set<String> list)
    {
        if(s.length() == arr.length)
        {
            list.add(s);
            return;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, s+String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        PermutationSolution permutationSolution = new PermutationSolution();
        String[] res =  permutationSolution.permutation("abc");
        System.out.println(res.length);
    }


}
