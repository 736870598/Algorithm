package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * --  回文数
 * https://leetcode-cn.com/problems/palindrome-number/description/
 * <p>
 * Created by sunxy on 2018/8/24 0024.
 */
public class LeetCode_9 {
    public static boolean isPalindrome(int x) {
        String oldStr = String.valueOf(x);
        String newStr = "";
        for (char c : oldStr.toCharArray()) {
            newStr = String.valueOf(c) + newStr;
        }
        return oldStr.equals(newStr);
    }

    public static void main(String[] s){
        System.out.print(" --> " + isPalindrome(2332
        ));
    }

}
