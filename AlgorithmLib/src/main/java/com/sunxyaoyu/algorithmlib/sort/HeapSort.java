package com.sunxyaoyu.algorithmlib.sort;

/**
 * 堆排序
 *
 * 如果当前节点时k
 父节点是：(k-1)/2
 左孩子是：2*k+1
 右孩子是：2*k+2
 *
 *
 * Created by Sunxy on 2018/2/26.
 */

public class HeapSort {


    /**
     * 需要完成一次建堆的过程
     * @param array
     * @param n 表示堆中有多少个数据
     * @param k 准备进行筛选的节点
     */
    public static void createHeap(int[] array, int n, int k){
        //根据结点K得到该结点的左右孩子位置
        int kLeft = 2*k+1;
        int kRight = 2*k+2;
        //如果左右孩子都不存在，直接返回
        if (kLeft>n && kRight>n){
            return;
        }

        //获取左右孩子的值，该堆建立的是最小堆顶，所以默认值取最大
        int kLeftValue = Integer.MAX_VALUE;
        int kRightValue = Integer.MAX_VALUE;
        if (kLeft < n){
            kLeftValue = array[kLeft];
        }
        if (kRight < n){
            kRightValue = array[kRight];
        }

        //到这里三个节点: k, kLeft, kRight
        // 三个结点的值：array[k]，kLeftValue，kRightValue

        //如果父节点的值是最小的，不需要调整
        if (array[k] <= kLeftValue && array[k] <= kRightValue){
            return ;
        }

        //如果左孩子的值比右孩子小，将左孩子的值赋值到k节点上，左子树重新建堆
        if (kLeftValue < kRightValue){
            int t=array[k];
            array[k] = array[kLeft];
            array[kLeft]= t;
            createHeap(array, n, kLeft);
        }else{
            int t=array[k];
            array[k] = array[kRight];
            array[kRight]= t;
            createHeap(array, n, kRight);
        }
    }

    public static void headSort(int array[]){
        //开始建堆
        //从最后一个非叶子（(array.length-1)/2）结点开始建
        for (int i = (array.length-1)/2; i>=0; i--){
            createHeap(array, array.length, i);
        }
        //开始边输出堆顶，边调整堆
        int n = array.length;
        while (n>0){
            System.out.print(array[0] + " ");
            //最后一个放到根上
            array[0] = array[n-1];
            n--;
            //重新调整
            createHeap(array, n, 0);
        }
    }

    public static void main(String[] args){
        int[] array = {6,5,4,2,7,1,3,9,8};
        headSort(array);
    }

}
