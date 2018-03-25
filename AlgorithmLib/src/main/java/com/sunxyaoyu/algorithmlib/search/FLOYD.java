package com.sunxyaoyu.algorithmlib.search;

/**
 *
 * 弗洛伊达算法，
 * 求俩点中间最短距离，用于公交系统/铁路站点等等
 *
 * Created by Sunxy on 2018/3/25.
 */
public class FLOYD {

    /**
     * 弗洛伊达
     * @return  路径P
     */
    public static int[][] floyd(int[][] array){
        //初始化路径点
        int[][] p = getP(array);
        //K是中转点
        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i][j] > array[i][k] + array[k][j]){
                        array[i][j] = array[i][k] + array[k][j];
                        //记录下路径
                        p[i][j] = p[i][k];
                    }
                }
            }
        }
        return p;
    }

    public static int[][] getP(int[][] array){
        int[][] p = new int[array.length][];
        for (int i = 0; i < p.length; i++) {
            int length = array[i].length;
            p[i] = new int[length];
            for (int j = 0; j < array[i].length; j++) {
                p[i][j] = j;
            }
        }
        return p;
    }


    public static void main(String[] args){
        int INF = Integer.MAX_VALUE;
        int[][] d = new int[][]{
                {0,2,1,5},
                {2,0,4,INF},
                {1,4,0,3},
                {5,INF,3,0}
        };

        int[][] p = floyd(d);

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

        //反推路径
        //找所有节点的路径
        for (int i = 0; i < d.length; i++) {
            //通过列号找到原来的一组路径
            for (int j = 0; j < d.length; j++) {
                System.out.print("V"+i+"->V"+j+", weight:"+d[i][j]+", path:"+i);
                int k=p[i][j];//先看路径中第0列，哪些是让改动了
                while(k!=j){
                    System.out.print("->"+k);
                    k=p[k][j];
                }
                System.out.println("->"+j);
            }
        }
    }

}
