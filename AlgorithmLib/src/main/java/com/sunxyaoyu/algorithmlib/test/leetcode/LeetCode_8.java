package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * --字符串转整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/description/
 * <p>
 * Created by sunxy on 2018/8/24 0024.
 */
public class LeetCode_8 {

    public static int myAtoi(String str) {

        int i = 0;
        int newNum = 0;
        boolean isZ = true;
        boolean isFirstN = true;
        while (i < str.length()){
            char c = str.charAt(i++);
             if (c == ' '){
                if (!isFirstN || newNum != 0){
                    break;
                }
            }else if(c== '-' || c== '+'){
                if (newNum == 0 && isFirstN){
                    isFirstN = false;
                    isZ = c== '+';
                }else{
                    break;
                }
            }else if('0' <= c && c <= '9'){
                 isFirstN = false;
                 int x = Integer.parseInt(String.valueOf(c));
                 if (newNum > Integer.MAX_VALUE / 10){
                        //要超限了。
                     return isZ ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                 }
                 if (newNum == Integer.MAX_VALUE / 10){
                     //可能要超限了。
                     if (isZ && x > 7){
                         return Integer.MAX_VALUE;
                     }else if(!isZ && x > 8){
                         return Integer.MIN_VALUE;
                     }
                 }
                 newNum = newNum * 10 + x;
            }else{
                break;
            }
        }
        return isZ ? newNum : -newNum;
    }

    public static void main(String[] s){
        String sdsd = "0-1";
        int x = myAtoi(sdsd);
        System.out.print("xx - > " + x);


    }


}
