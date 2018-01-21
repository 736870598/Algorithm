package com.sunxyaoyu.algorithmlib.sort;

/**
 * 分治法 ---- 归并排序
 *
 * 适用于数据量大而且是链式存储
 * 短板：占用空间大
 *
 * Created by Sunxy on 2018/1/21.
 */
public class MergeSort {

    public static void mergeSort(int array[], int left, int right){
        if (left==right){
            return;
        }else {
            int mid = (left+right)/2;
            mergeSort(array,left,mid);          //排好左边
            mergeSort(array,mid+1,right);   //排好右边
            merge(array,left,mid+1,right);  //合并
        }
    }

    public static void merge(int[] array, int left, int mid, int right){
        int leftSize = mid-left;
        int rightSize = right-mid+1;
        //生成数组
        int[] leftArray=new int[leftSize];
        int[] rightArray=new int[rightSize];
        //添充左边数组
        for (int i=left;i<mid;i++){
            leftArray[i-left]=array[i];
        }
        //添充右边数组
        for (int i=mid;i<=right;i++){
            rightArray[i-mid]=array[i];
        }

        //合并数据
        int i=0,j=0,k=left;
        while (i<leftSize && j<rightSize){
            if (leftArray[i] < rightArray[j]){
                array[k++] = leftArray[i++];
            }else{
                array[k++] = rightArray[j++];
            }
        }
        while (i<leftSize){
            array[k++] = leftArray[i++];
        }
        while (j<rightSize){
            array[k++] = rightArray[j++];
        }
    }



    public static void main(String[] args){
        int[] array = new int[]{1,2,5,9,3,4,20,12};
        mergeSort(array, 0, array.length-1);

        for (int i:array ) {
            System.out.print(i+"  ");
        }

    }
}
