package com.sunxyaoyu.algorithmlib.test;

/**
 *
 * 日程赛
 *
 * 2^n 个选手比赛
 *  每个选手一天赛一场，每个选手要和其他的选手都要比一次
 *
 *
 * Created by Sunxy on 2018/2/5.
 */
public class GameTest {

    public static int[][] table(int k){
        int n = 1<<k;
        int[][] array = new int[n][n];

        for (int i=0; i<n; i++){
            array[0][i] = i+1;
        }

        for (int r=1; r<n; r=r*2){
            for (int i=0; i<n; i=i+r*2){
                copy(array, 0, i, r, r+i, r);
                copy(array, 0, r+i, r, i, r);
            }
        }
        return array;
    }


    /**
     * 拷贝数组中的一块区域 r:表示在对角线上的元素个数
     * @param array
     * @param fromx
     * @param fromy
     * @param tox
     * @param toy
     * @param r
     */
    public static void copy(int[][] array, int fromx, int fromy, int tox, int toy, int r){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < r; j++){
                array[tox+i][toy+j] = array[fromx+i][fromy+j];
            }
        }
    }

    public static void main(String[] args){
        int[][] table = table(3);
        for (int i = 0 ; i < table.length; i++){
            for (int j=0; j<table[i].length; j++){
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
