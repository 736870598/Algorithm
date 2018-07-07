package com.sunxyaoyu.algorithmlib.test;

/**
 * -  数独
 * <p>
 * Created by Sunxy on 2018/7/7.
 */
public class Sudoku {

    private static int[][] result1 = new int[9][9];
    public static int[][] result={
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };


    public static void sudoku(int i, int j){
        //推出条件
        if (i == 8 && j == 9){
            printResult();
            return;
        }
        //换行
        if (j == 9){
            i++;
            j=0;
        }
        if (result[i][j] == 0){
            for (int k = 1; k <= 9; k++) {
                if (judge(i,j,k)){
                    result[i][j] = k;
                    sudoku(i, j+1);
                    //让前一次格子还原
                    result[i][j] = 0;
                }
            }
        }else{
            sudoku(i, j+1);
        }
    }

    /**
     * 判断是否符合条件
     */
    private static boolean judge(int row, int col, int number){
        for (int i = 0; i < 9; i++) {
            //同行或同列是否有
            if (result[row][i] == number || result[i][col] == number){
                return false;
            }
        }

        //同宫是否有
        int tempRow = row/3;
        int tempCol = col/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (result[tempRow*3+i][tempCol*3+j] == number){
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * 打印结果
     */
    private  static void printResult(){
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        sudoku(0,0);
    }
}
