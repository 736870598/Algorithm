package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * -
 * <p>
 * Created by Sunxy on 2018/12/24.
 */
public class LeetCode_32 {

    public static void main(String[] args){
        String str = "(()";
        int i = longestValidParentheses(str);
        System.out.println("count : " + i);
    }


    public static int longestValidParentheses(String s) {
        int length = s.length();
        if (length == 0) return 0;

        int zhenCount = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            String index = String.valueOf(s.charAt(i));
            if (index.equals("(")){
                zhenCount++;
            }
            else if(index.equals(")")){
                if (zhenCount > 0){
                    zhenCount--;
                    count++;
                }
            }
        }
        return count * 2;

    }

}
