package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * -最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 * <p>
 * Created by Sunxy on 2018/8/24.
 */
public class LeetCode_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String minLengthStr = getMinLengthStr(strs);
        int index = 0;
        for (int i = 0; i < minLengthStr.length(); i++) {
            boolean isSame = isSameAsChar(strs, i, minLengthStr.charAt(i));
            if (isSame){
                index++;
            }else{
                break;
            }
        }
        return minLengthStr.substring(0, index);
    }

    private String getMinLengthStr(String[] strs){
        String minLengthStr = strs[0];
        for (String str : strs) {
            minLengthStr = minLengthStr.length() > str.length() ? str : minLengthStr;
        }
        return minLengthStr;
    }

    private boolean isSameAsChar(String[] strs, int index, char c){
        for (String str : strs) {
            if (str.charAt(index) != c){
                return false;
            }
        }
        return true;
    }


}
