package com.yochiu.algorithms.code_interviews;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'
 * 输入：a = 15, b = 2
 * 输出：7
 *
 * 输入：a = 7, b = -3
 * 输出：-2
 */
public class DivideSolution {

    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        int c = Math.abs(a);
        int d = Math.abs(b);
        int res = 0;
        for (int i = 0; i <= c; i++) {
            if (i * d > c) {
                break;
            }
            res = i;
        }
        if (a < 0) {
            res = b > 0 ? -res : res;
        } else {
            res = b > 0 ? res : -res;
        }
        return res;
    }


}
