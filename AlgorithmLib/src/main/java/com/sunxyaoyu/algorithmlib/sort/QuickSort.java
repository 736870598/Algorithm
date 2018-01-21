package com.sunxyaoyu.algorithmlib.sort;

/**
 * 分治法 ---- 快速排序
 *  公认排序最快的算法
 *
 *  适用于数据量大的顺序存储。不适用链式存储的数据 和 有大量重复数据的
 *
 *
 * Created by Sunxy on 2018/1/20.
 */

public class QuickSort {

    /**
     * 快速排序   递归
     * @param array
     * @param begin
     * @param end
     */
    public static void quickSort(int[] array, int begin, int end){
        if (end-begin<=1) return;
        int x = array[begin];
        int low = begin;
        int high = end;
        //遍历方向
        boolean direction = true;

        L1:
        while (low<high){
            if (direction){
                for (int i = high; i>low; i--){
                    if (array[i] <= x){
                        array[low++] = array[i];
                        high = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                high = low;
            }else{
                for (int i = low; i<high; i++){
                    if (array[i]>x){
                        array[high--] = array[i];
                        low = i;
                        direction = !direction;
                        continue L1;
                    }
                }
                low = high;
            }
        }
        //把最后找到的值放入中间位置
        array[low]=x;

        //这些左右俩边的操作
        quickSort(array, begin, low-1);
        quickSort(array, low+1, end);
    }


    public static void main(String[] args){
        int[] array = new int[]{31,21,59,68,12,40};
        quickSort(array, 0, array.length-1);
        for (int i: array ) {
            System.out.print( i + "  ");
        }
    }
}
