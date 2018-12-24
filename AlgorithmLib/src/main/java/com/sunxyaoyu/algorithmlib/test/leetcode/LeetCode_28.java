package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 28. 实现strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * SunXiaoYu on 2018/12/24.
 * mail: sunxiaoyu@hexinpass.com
 */
public class LeetCode_28 {

    public static void main(String[] str){
        int i = strStr("", "");
        System.out.println("index: " + i);
    }

    public static int strStr(String haystack, String needle) {
        int needStrSize = needle.length();
        if (needStrSize == 0) return 0;
        int size = haystack.length();
        if (size == 0) return -1;
        int index;
        for (int i = 0; i < size; i++) {
            if (size - i < needStrSize){   //长度不够了
                return -1;
            }
            index = i;
            boolean isSame = true;
            for (int j = 0; j < needStrSize; j++) {
                if (haystack.charAt(index+j) != needle.charAt(j)){
                    isSame = false;
                    break;
                }
            }
            if (isSame){
                return index;
            }
        }
        return -1;
    }
}
