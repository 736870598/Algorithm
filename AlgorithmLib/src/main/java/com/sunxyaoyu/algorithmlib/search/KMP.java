package com.sunxyaoyu.algorithmlib.search;


/**
 *
 * 字符串匹配算法 （精确匹配）
 *
 * Created by Sunxy on 2018/3/25.
 */
public class KMP {

    /**
     * next数组含义： 第i个位置上往前数next[i]个和最前面的next[i]个一样
     */
    private static int[] kmpNext(String dest) {
        int next[] = new int[dest.length()];
        next[0] = 0;
        //开始推出next
        // 第3步 i++
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j>0 && dest.charAt(j) != dest.charAt(i)){
                j=next[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                // 第1步 相等，j移动
                j++;
            }
            // 第2步 赋值
            next[i] = j;
        }

        return next;
    }


    private static int kmp(String str, String dest, int[] next){
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if (str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if (j == dest.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        String str = "ababcbababcabacaba";
        String dest = "ca";

        int[] array = kmpNext(dest);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }

        int index = kmp(str, dest, array);
        System.out.println();
        System.out.println("index : " + index);
    }


}
