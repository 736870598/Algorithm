package com.sunxyaoyu.algorithmlib.sort;

/**
 * 希尔排序
 *
 * Created by Sunxy on 2018/2/10.
 */
public class ShellSort {

    public static void shellSort(int[] array, int step){
        for (int k=0; k<step; k++){

            for (int i=k+step; i<array.length; i+=step){
                int j = i;
                int target = array[i];
                while (j>step-1 && target < array[j-step]){
                    array[j] = array[j-step];
                    j-=step;
                }
                array[j] = target;
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{3,7,8,1,2,5,6,9,0,4};
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        shellSort(array,4);
        shellSort(array,1);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }

    }

}
