package com.sunxyaoyu.algorithmlib.sort;

import java.util.LinkedList;

/**
 * 基数排序（补位按为排序）
 * Created by Sunxy on 2018/2/5.
 */

public class RadixSort {

    public static void radixSort(LinkedList<MaHjong> list){
        //先对点数进行分组
        LinkedList<MaHjong> randList[] = new LinkedList[9];
        for (int i = 0; i < randList.length; i++){
            randList[i] = new LinkedList();
        }

        //把数据一个一个放入到对应的组中
        while (list.size()>0){
            MaHjong m = list.remove();
            //根据点数放到对应的组中
            randList[m.rand-1].add(m);
        }

        //把9个组合到一起
        for (int i = 0; i<randList.length; i++){
            list.addAll(randList[i]);
        }

        //再对花色进行排序，
        LinkedList<MaHjong> suitList[] = new LinkedList[3];
        for (int i = 0; i < suitList.length; i++){
            suitList[i] = new LinkedList();
        }

        //把数据一个一个放入到对应的组中
        while (list.size()>0){
            MaHjong m = list.remove();
            //根据花色放到对应的组中
            suitList[m.suit-1].add(m);
        }

        //把几个组合到一起
        for (int i = 0; i<suitList.length; i++){
            list.addAll(suitList[i]);
        }


    }


    /**
     * 麻将实体类
     */
    public static class MaHjong{

        //麻将的点数
        public int rand;
        //麻将的花色
        public int suit;

        public MaHjong(int rand, int suit) {
            this.rand = rand;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return "MaHjong{" +
                    "rand=" + rand +
                    ", suit=" + suit +
                    '}';
        }
    }


    public static void main(String[] args){
        LinkedList<MaHjong> linkedList = new LinkedList<>();
        linkedList.add(new MaHjong(5,3));
        linkedList.add(new MaHjong(4,1));
        linkedList.add(new MaHjong(3,2));
        linkedList.add(new MaHjong(6,3));
        linkedList.add(new MaHjong(5,3));
        linkedList.add(new MaHjong(3,2));
        linkedList.add(new MaHjong(5,2));
        linkedList.add(new MaHjong(6,1));
        linkedList.add(new MaHjong(7,1));
        linkedList.add(new MaHjong(8,3));
        linkedList.add(new MaHjong(4,3));
        linkedList.add(new MaHjong(7,3));

        radixSort(linkedList);

        for (int i = 0; i < linkedList.size(); i++){
            System.out.println(linkedList.get(i).toString());
        }

    }
}
