package com.sunxyaoyu.algorithmlib.test.leetcode;

import java.util.Map;

/**
 * --反转整数
 * https://leetcode-cn.com/problems/reverse-integer/description/
 * <p>
 * Created by sunxy on 2018/8/24 0024.
 */
public class LeetCode_7 {

    public static int reverse(int x) {
        boolean isZ =  x > 0;
        x = Math.abs(x);
        int length = String.valueOf(x).length();
        long newNum = 0;
        for (int i = 0; i < length; i++) {
            int num = (int) (x % Math.pow(10, i+1) / Math.pow(10, i));
            newNum += num * Math.pow(10, length - i - 1);
        }
        if (!isZ){
            newNum = -newNum;
        }
        if (newNum > Integer.MAX_VALUE){
            return 0;
        }
        if (newNum < Integer.MIN_VALUE){
            return 0;
        }
        return (int) newNum;
    }

    public static void main(String[] s){
        int x= -1293405656;
        int newNum = reverse(x);
        System.out.print("newNum -> " + newNum);
    }

}
