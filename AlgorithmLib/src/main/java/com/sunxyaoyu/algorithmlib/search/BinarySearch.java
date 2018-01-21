package com.sunxyaoyu.algorithmlib.search;

/**
 *
 * 分治法 ---- 二分查找
 *
 * 前提：
 *  数据有序，如果是无序数据的话只有 顺序查找 可用
 *
 * Created by Sunxy on 2018/1/20.
 */

public class BinarySearch {

    public static int binarySearch(int[] array, int fromIndex, int toindex, int key){
        int low = fromIndex;
        int high = toindex-1; //左闭右开
        while (low<=high){
            int mid = (low+high)>>>1; //>>>1 无符号除2
            int midValue = array[mid];
            if (key>midValue){
                low=mid+1;
            }else if(key<midValue){
                high = mid-1;
            }else {
                return mid;
            }
        }
        return -(low+1);
    }


    public static void main(String[] args){
        int[] array = new int[]{1,2,5,8,12,15,35,57,89,90};
        int index = binarySearch(array,0, array.length, 83);
        System.out.println("index == " + index);
    }


}
