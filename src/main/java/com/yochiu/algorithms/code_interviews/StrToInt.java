package com.yochiu.algorithms.code_interviews;

public class StrToInt {

    public int strToInt(String str) {
        char[] array = str.toCharArray();
        int sum = 0;
        boolean isNegative = true;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == ' ') {
                if (i > 0) {
                    char pre = array[i-1];
                    if (pre >= '0' && pre <= '9') {
                        return isNegative ? sum : - sum;
                    }
                }
                continue;
            }
            if (c == '-') {
                if (i < array.length - 1) {
                    char next = array[i+1];
                    if (next < '0' || next > '9') {
                        return isNegative ? sum : - sum;
                    }
                }
                if (i > 0) {
                    char pre = array[i-1];
                    if (pre >= '0' && pre <= '9') {
                        return isNegative ? sum : - sum;
                    }
                }
                isNegative = false;
                continue;
            }
            if (c == '+') {
                if (i < array.length - 1) {
                    char next = array[i+1];
                    if (next < '0' || next > '9') {
                        return isNegative ? sum : - sum;
                    }
                }
                if (i > 0) {
                    char pre = array[i-1];
                    if (pre >= '0' && pre <= '9') {
                        return isNegative ? sum : - sum;
                    }
                }
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            }
            long a = ((long) sum * 10 + (c - '0')) * (isNegative ? 1 : -1);
            if (a > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (a <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            sum = sum * 10 + (c - '0');
        }
        return isNegative ? sum : - sum;
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.strToInt("   -42"));
        System.out.println(strToInt.strToInt("4193 with words"));
        System.out.println(strToInt.strToInt("words and 987"));
        System.out.println(strToInt.strToInt("-91283472332"));
        System.out.println(strToInt.strToInt("+-2"));
        System.out.println(strToInt.strToInt("21474836++"));
    }

}
