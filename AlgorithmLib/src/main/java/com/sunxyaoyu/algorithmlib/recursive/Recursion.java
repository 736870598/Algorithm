package com.sunxyaoyu.algorithmlib.recursive;

/**
 * 递归
 *
 * 1次递归自己：先正循环后返循环
 * 2次递归自己：二叉树问题
 *
 * Created by Sunxy on 2018/1/20.
 */
public class Recursion {

    /**
     * 斐波纳契数列
     */
    public static int FibonacciSequence(int n){
        if (n == 1 || n == 2){
            return 1;
        }else{
            return FibonacciSequence(n-1) + FibonacciSequence(n-2);
        }
    }

    /**
     * 汉罗塔问题
     * @param n         个数
     * @param start     开始柱子
     * @param middle    中间柱子
     * @param end       最后柱子
     */
    public static void hanoi(int n, int start, int middle, int end){
        if (n <= 1){
            System.out.println(start+" ---> " + end);
        }else{
            hanoi(n-1, start, end, middle);
            System.out.println(start+" ---> " + end);
            hanoi(n-1, middle, start, end);
        }
    }


    public static void main(String[] args){
        System.out.println(FibonacciSequence(7));
        hanoi(64,1,2,3);
    }
}
