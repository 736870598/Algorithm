package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * -- 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 * <p>
 * Created by sunxy on 2018/8/23 0023.
 */
public class LeetCode_5 {

    public static String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 1){
            return s;
        }
        int maxLength = 0;
        int maxLengthIndex = 0;
        for (int i = 0; i < strLength; i++) {
            int len1 = expandAroundCenter(s, strLength, i, i);
            int len2 = expandAroundCenter(s, strLength, i, i+1);
            int len = Math.max(len1, len2);
            if (len >= maxLength ){
                maxLength = len;
                maxLengthIndex = i;
            }
        }

        int start = maxLengthIndex - (maxLength-1) / 2;
        int end = maxLengthIndex + maxLength / 2;

        return s.substring(start, end+1);

    }

    private static int expandAroundCenter(String s, int length, int start, int end) {
        int l = start;
        int r = end;
        while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        //最后异常多走了一次，这里往回走一次
        l++;
        r--;
        return r-l+1;
    }


    public static void main(String[] s){
        String str = "sdsds";
        String longestStr = longestPalindrome(str);
        System.out.print("longestStr -> " + longestStr);
    }

}






