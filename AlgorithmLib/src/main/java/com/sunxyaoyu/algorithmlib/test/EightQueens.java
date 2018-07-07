package com.sunxyaoyu.algorithmlib.test;

/**
 * - 八皇后问题
 * 在国际象棋中有八个皇后，8*8坐标上 每个皇后所在的、位置 的行，列，斜线方向都只能有一个皇后，一共有多少中放法？
 * <p>
 * Created by Sunxy on 2018/7/3.
 */
public class EightQueens {

    //array[n]表示第n列， n表示第几行
    public static int[] array = new int[8];

    public static void eightQueens(int row){
        if (row == 8){
            printResult();
            return;
        }
        for (int col = 0; col < 8; col++) {
            array[row] = col;
            if (judge(row)){
                eightQueens(row+1);
            }
        }

    }


    public static boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //在不在同一列，               在不在对角线上面
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i]) ){
                return false;
            }
        }
        return true;
    }

    public static void printResult(){
        for (int i = 0; i < 8; i++) {
            System.out.print(array[i] + "-");
        }
        System.out.println();
    }

    public static void main(String[] args){
        eightQueens(0);
    }

}
