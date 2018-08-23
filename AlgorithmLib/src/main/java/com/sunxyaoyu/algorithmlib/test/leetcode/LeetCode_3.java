package com.sunxyaoyu.algorithmlib.test.leetcode;


/**
 * --无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 * <p>
 * Created by sunxy on 2018/8/21 0021.
 */
public class LeetCode_3 {
    public static int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        int maxLength = 0;
        for (int i = 0; i < strLength; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = i; j < strLength; j++) {
                String charStr = String.valueOf(s.charAt(j));
                if (sb.toString().contains(charStr)){
                    break;
                }
                sb.append(charStr);
            }
            maxLength = maxLength > sb.length() ? maxLength : sb.length();
        }
        return maxLength;
    }


public static void main(String[] a){
    lengthOfLongestSubstring("pwwkew");
}

}
