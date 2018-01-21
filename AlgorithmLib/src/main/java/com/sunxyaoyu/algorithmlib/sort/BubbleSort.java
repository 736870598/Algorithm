package com.sunxyaoyu.algorithmlib.sort;

/**
 * 蛮力法----冒泡排序
 *
 * 多用于 3-5个数的排序
 *
 * Created by sunxy on 2018/1/20.
 */
public class BubbleSort {

    /**
     * 常规冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array){
        for (int i = array.length-1; i>0; i--){
            for (int j = 0; j < i; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 改良版冒泡排序
     * 增加flag 一次循环后如果flag为true，说明已经有序了
     */
    public static void bubbleSort2(int[] array){
        for (int i = array.length-1; i>0; i--){
            boolean flag = true;
            for (int j = 0; j < i; j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }




    public static void main(String[] args){
        int[] array = new int[]{3,1,2,5,4,7,9,8,6};
        bubbleSort2(array);
        for (int i: array ) {
            System.out.println(i);
        }

    }

}
