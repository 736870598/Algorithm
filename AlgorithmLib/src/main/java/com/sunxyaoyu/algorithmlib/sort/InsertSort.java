package com.sunxyaoyu.algorithmlib.sort;

/**
 *
 * 直接插入排序
 * （就像平时打扑克的时候搬牌时一样的）
 *
 * Created by Sunxy on 2018/2/10.
 */
public class InsertSort {

    public static void insertSort(int[] array){
        for (int i=0; i<array.length; i++){
            int j = i;
            int target=array[i];
            //如果要插入的数据小于数组的前一个时
            while (j>0 && target<array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j]=target;
        }
    }


    public static void main(String[] args){
        int[] array = new int[]{3,2,8,7,6,5,4,0,1,9};
        insertSort(array);
        for (int i =0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }



}
