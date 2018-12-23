package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 20. 有效的括号
 * -https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * Created by Sunxy on 2018/12/23.
 */
public class LeetCode_20 {

    public static void main(String[] args){

        String str = "[]";
        boolean result = isValid(str);
        System.out.println(str + "--->" + result);

    }

    private static String zhenStr = "({[";
    private static String[] zhenStrArray = {"(","{","["};
    private static String otherStr = ")}]";

    public static boolean isValid(String s) {
        if (s == null){
            return false;
        }

       String mainStr = "";

        for (char c : s.toCharArray()) {
            String indexStr = String.valueOf(c);
            if (zhenStr.contains(indexStr)){
                mainStr += indexStr;
            }else{
                if (!mainStr.endsWith(getOtherStr(indexStr))){
                    return false;
                }
                mainStr = mainStr.substring(0, mainStr.length()-1);
            }
        }

        return mainStr.isEmpty();
    }

    public static String getOtherStr(String str){
        int index = otherStr.indexOf(str);
        if (index >= 0 && index < zhenStrArray.length){
            return zhenStrArray[index];
        }
        return "-1";
    }

}
