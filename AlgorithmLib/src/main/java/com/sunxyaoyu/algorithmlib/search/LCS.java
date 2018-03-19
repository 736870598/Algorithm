package com.sunxyaoyu.algorithmlib.search;

import java.util.Stack;

/**
 *
 * 最长公共子序列
 * Created by sunxy on 2018/3/19 0019.
 */
public class LCS {

    public static void getLCS(String x, String y){
        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        int[][] array = new int[s1.length+1][s2.length+1];
        //第一行第一列置零
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 0;
        }

        //填入数据--相等左上角加一，不等取左或上的最大值加一
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (s1[i-1] == s2[j-1]){
                    array[i][j] = array[i-1][j-1] + 1;
                }else{
                    array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
                }
            }
        }

        //打印二维数组
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                System.out.print(array[i][j] + "");
            }
            System.out.println();
        }

        //获取最大相似度
        System.out.println("mast ==>" + array[s1.length][s2.length]);

        //输入相似字符串
        Stack result=new Stack();
        int i=x.length()-1;
        int j=y.length()-1;
        while ((i>=0) && (j >=0)){
            if (s1[i] == s2[j]){
                result.push(s1[i]);
                i--;
                j--;
            }else{
                if(array[i+1][j-1+1]>array[i-1+1][j+1]){//注意数组和String中的位置有一位的差
                    j--;
                }else{
                    i--;
                }
            }
        }
        while(!result.isEmpty()){
            System.out.print(result.pop()+" ");
        }
    }


    public static void main(String[] args){
        getLCS("ABCBDAB","BDCABA");
    }

}
