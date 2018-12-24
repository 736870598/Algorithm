package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 * SunXiaoYu on 2018/12/24.
 * mail: sunxiaoyu@hexinpass.com
 */
public class LeetCode_29 {

    public static void main(String[] args){
        int divide = divide(-2147483648, -1);
        System.out.println("divide: " + divide);
    }

    public static int divide(int dividend, int divisor) {
        boolean isZ;
        if (dividend > 0 && divisor > 0){
            isZ = true;
        }else if(dividend < 0 && divisor < 0){
            isZ = true;
        }else{
            isZ = false;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int x=0;
        while ( dividend >= divisor){
            x++;
            dividend = dividend - divisor;
        }
        return isZ ? x : -x;
    }
}
