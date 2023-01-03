package com.yochiu.algorithms.code_interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 将一个给定字符串s根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAY P ALI S HIR I NG" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

public class ZnumRows {

    public String convert(String s, int numRows) {
        List<StringBuilder> res = new ArrayList<>(numRows);
        for (int i = 0; i <numRows; i++) {
            res.add(new StringBuilder());
        }
        int flag = -1, i = 0;
        for (char c : s.toCharArray()) {
            res.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder rs = new StringBuilder();
        for (StringBuilder sb: res) {
            rs.append(sb.toString());
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        ZnumRows znumRows = new ZnumRows();
        String s = znumRows.convert("PAYPALISHIRING", 4);
        System.out.println(s.equals("PINALSIGYAHRPI"));
    }

}
