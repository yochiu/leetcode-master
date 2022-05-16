package com.yochiu.algorithms.code_interviews;

public class MinWindow {

    public String minWindow(String s, String t) {
        char[] array = s.toCharArray();
        int[] have = new int[256];
        int[] origin = new int[256];
        for (char c : t.toCharArray()) {
            origin[c]++;
        }
        int left = 0, right = 0, count = 0;
        int min =  s.length() + 1;
        int start = 0;
        while (right < array.length) {
            char c = array[right];
            if (origin[c] == 0) {
                right++;
                continue;
            }
            if (have[c] < origin[c]) {
                count++;
            }
            have[c]++;
            right++;
            while (count == t.length()) {
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char a = array[left];
                if (have[a] == 0) {
                    left++;
                    continue;
                }
                if (have[a] == origin[a]) {
                    count--;
                }
                have[a]--;
                left++;
            }
        }
        if (min == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + min);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("BBBBBBBAC", "ABC"));
    }
}
