package com.sunxyaoyu.algorithmlib.test;

import java.util.ArrayList;
import java.util.List;

/**
 * - 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手机没牌，最后桌子上的牌是从1到n有序，设计程序，输入n，输出牌堆的顺序数组
 * <p>
 * Created by Sunxy on 2018/7/30.
 */
public class AlgorithmTest_1 {
    public static void algorithm(int n){

        //构建list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        List<Integer> indexList = new ArrayList<>();
        while (true){
            indexList.add(list.remove(0));
            if (list.isEmpty()){
                break;
            }
            list.add(list.remove(0));
        }

//        到这里 indexList 就是最终的下标集合，要求输出的是1—n顺序的，那么就是下标对应的值是顺序的。
//        比如：12345那么玩一遍的结果是24531， 那么x[2]=1 x[4]=2 x[5]=3 x[3]=4 x[1]=5

        //给value数组赋值
        int[] valueArray = new int[n];
        for (int i = 0; i < n; i++) {
            //查找值为i的，也就是下标为i，值就是对应的第几个顺序。
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (indexList.get(j) == i){
                    valueArray[i] = index;
                }
                index++;
            }
        }

        for (int i : valueArray) {
            System.out.print(i + "--");
        }

    }


    public static void main(String[] args){
        algorithm(8);
    }
}
