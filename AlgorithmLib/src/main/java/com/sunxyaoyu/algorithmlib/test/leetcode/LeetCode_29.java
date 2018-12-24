package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 29. 两数相除  (这是很无聊的一道题，。，，，，，，，，，，，，，，，，，，，，)
 * https://leetcode-cn.com/problems/divide-two-integers/
 * SunXiaoYu on 2018/12/24.
 * mail: sunxiaoyu@hexinpass.com
 */
public class LeetCode_29 {

    public static void main(String[] args){
        int divide = divide(-2147483648, 2);
        System.out.println("divide: " + divide);
    }

    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1){
            return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        boolean isZ;
        if (dividend > 0 && divisor > 0){
            isZ = true;
        }else if(dividend < 0 && divisor < 0){
            isZ = true;
        }else{
            isZ = false;
        }

        if (isZ){

        }
        int x=0;
        while ( dividend >= divisor){
            x++;
            dividend = dividend - divisor;
        }
        return isZ ? x : -x;
    }
}
