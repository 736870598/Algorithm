package com.sunxyaoyu.algorithmlib;

/**
 * 蛮力法----选择排序
 * 适用于5-8个数的排序。
 * 定位算法很金典
 *
 * Created by Sunxy on 2018/1/20.
 */
public class SelectSort {

    public static void selectSort(int array[]){
        for (int i = 0; i < array.length-2; i++){
            int index = i;
            //定位,找到最小的
            for (int j = i+1; j< array.length; j++){
                if (array[j] < array[index]){
                    index = j;
                }
            }
            if (index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

    }

    public static void main(String[] args){
        int[] array = new int[]{3,1,2,50,4,7,9,8,6};
        selectSort(array);
        for (int i: array ) {
            System.out.println(i);
        }
    }

}
