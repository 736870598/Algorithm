package com.sunxyaoyu.algorithmlib.test.leetcode;


/**
 * -- Z字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 * <p>
 * Created by sunxy on 2018/8/23 0023.
 */
public class LeetCode_6 {
    public static String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }
        String[] rowStr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rowStr[i] = "";
        }
        boolean isDown = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            rowStr[index] += String.valueOf(s.charAt(i));

            if (isDown){
                if ((index+1) >= numRows){
                    isDown = false;
                    index--;
                }else{
                    index++;
                }
            }else{
                if ((index-1) < 0){
                    isDown = true;
                    index++;
                }else{
                    index--;
                }
            }
        }
        String result = "";
        for (String s1 : rowStr) {
            result += s1;
        }
        return result;
    }

    public static void main(String[] s){
        String c = convert("PAYPALISHIRING", 3);
        System.out.println(c);
        System.out.print("PAHNAPLSIIGYIR");
    }
}
