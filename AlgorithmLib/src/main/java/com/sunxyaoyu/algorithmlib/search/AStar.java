package com.sunxyaoyu.algorithmlib.search;

import java.util.ArrayList;

/**
 * A* 寻路算法
 *
 * 地图设计的时候死路要至少能同时站俩个人
 *
 * Created by Sunxy on 2018/3/12 0012.
 */
public class AStar {


    public static void main(String[] args){
        int[][] map = {
                {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                {3,1,0,0,0,0,0,0,0,0,0,0,0,0,3},
                {3,0,0,0,0,0,0,0,0,0,0,3,0,0,3},
                {3,0,0,0,0,0,0,0,0,0,0,3,0,0,3},
                {3,0,0,0,0,0,0,0,0,0,0,3,0,0,3},
                {3,0,0,0,0,0,0,0,0,0,0,3,0,0,3},
                {3,3,3,3,3,3,3,3,3,3,3,3,0,3,3},
                {3,0,0,0,0,0,0,0,0,0,0,0,0,0,3},
                {3,0,0,0,0,0,0,0,0,0,0,0,0,2,3},
                {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
        };
        A a = new A();
        a.test(map);
    }



    static class A{
        //用来保存所有能走的路
        public ArrayList<P> openArray = new ArrayList<>();
        //用来保存所有不能走的路
        public ArrayList<P> closeArray = new ArrayList<>();
        //起点 和 终点
        public P startPoint, endPoint;
        //地图信息  0-能走的路，1-起点/走过的路，2-终点，3-不能走的路
        public int[][] map;

        public void init(){
            for (int i= 0; i < map.length; i++){
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j]==1){
                        startPoint=new P(i,j);
                        openArray.add(new P(i,j));
                    }else if(map[i][j]==3){
                        closeArray.add(new P(i,j));
                    }else if(map[i][j]==2){
                        endPoint=new P(i,j);
                    }
                }
            }
        }

        /**
         * 计算点到点的距离
         */
        public double pointToPoint(P start, P end){
            int b = Math.abs(start.x-end.x);
            int a = Math.abs(start.y-end.y);
            return Math.sqrt(a*a+b*b);
        }

        /**
         * 计算起点到节点的距离
         */
        public double g(P start, P node){
            return pointToPoint(start, node);
        }

        /**
         * 计算节点到终点的距离
         */
        public double h(P node, P end){
            return pointToPoint(node, end);
        }

        /**
         * 估价函数
         */
        public double f(P start, P node, P end){
            return g(start, node) + h(node, end);
        }

        /**
         * open队列，开始收集所有可用的路径
         */
        public void openFn(P p){
            //是否为终点
            if (p.x==endPoint.x && p.y==endPoint.y){
                return;
            }
            //标记当前位置
            map[p.x][p.y]=1;
            //找相邻位置，确认下一个目标点在哪
            P p2 = lookUp(p);
            //递归下一个位置
            openFn(p2);
        }

        /**
         * 返回找到的下一个节点
         */
        public P lookUp(P p){
            //存放所有能走的路径
            ArrayList<P> result=new ArrayList<>();
            //开始搜索自己周围能走的路
            if(map[p.x][p.y+1]!=3 && map[p.x][p.y+1]!=1){//右
                result.add(new P(p.x,p.y+1));
            }
            if(map[p.x+1][p.y+1]!=3 && map[p.x+1][p.y+1]!=1){//右下
                result.add(new P(p.x+1,p.y+1));
            }
            if (map[p.x+1][p.y]!=3 && map[p.x+1][p.y]!=1){ //下
                result.add(new P(p.x+1,p.y));
            }
            if(map[p.x+1][p.y-1]!=3 && map[p.x+1][p.y-1]!=1){//左下
                result.add(new P(p.x+1,p.y-1));
            }
            if(map[p.x][p.y-1]!=3 && map[p.x][p.y-1]!=1){//左
                result.add(new P(p.x,p.y-1));
            }
            if(map[p.x-1][p.y-1]!=3 && map[p.x-1][p.y-1]!=1){//左上
                result.add(new P(p.x-1,p.y-1));
            }
            if(map[p.x-1][p.y]!=3 && map[p.x-1][p.y]!=1){//上
                result.add(new P(p.x-1,p.y));
            }
            if(map[p.x-1][p.y+1]!=3 && map[p.x-1][p.y+1]!=1){//右上
                result.add(new P(p.x-1,p.y+1));
            }

            //经过上面的一组if，result中就存下了所有能走的路
            double[] temp=new double[result.size()];
            for (int i = 0; i < result.size(); i++) {
                temp[i]=f(p, result.get(i), endPoint);
            }
            //在能用的位置中找到最小的那个
            int minIndex = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[minIndex] > temp[i]){
                    minIndex = i;
                }
            }
            //保存估算最近到终点的那个点
            P minPoint = result.get(minIndex);
            return minPoint;
        }

        public void test(int[][] map){
            this.map = map;
            init();
            openFn(startPoint);
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    /**
     *  点坐标消息model
     */
    static class P{
        public int x;
        public int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
