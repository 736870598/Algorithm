package com.sunxyaoyu.algorithmlib.search;


/**
 * 深度优先算法
 *
 * Created by Sunxy on 2018/3/4.
 */

public class DFS {

    public static boolean dfs(int x,int y){
        if (map[endX][endY] == 2){
            return true;
        }
        if (map[x][y] == 0){    // 0 没有走过
            map[x][y] = 2;      // 2 走过, 1走过的死路
            //    左                  下             右               上
            if (dfs(x, y-1) || dfs(x+1,y) || dfs(x, y+1) || dfs(x-1, y)){
                return true;
            }else{
                //如果四个方向都不能走了，开始回退到之前能走的位置
                map[x][y] = 1;
                return false;
            }
        }else {
            return false;
        }
    }

    static int startX = 1, startY = 1;
    static int endX = 6, endY = 11;
    static int[][] map = {
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,0,0,0,3,3,3,3,3,0,0,0,3,3,3},
            {3,3,0,0,0,0,3,3,3,0,3,0,3,3,3},
            {3,3,0,3,3,0,3,3,3,0,3,0,3,3,3},
            {3,3,3,3,0,0,0,0,0,0,3,0,3,3,3},
            {3,3,3,3,0,3,3,3,3,0,3,0,0,0,3},
            {3,3,3,0,0,3,3,3,3,0,3,0,3,3,3},
            {3,0,0,0,3,3,3,3,3,3,3,0,0,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,0,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
    };

    public static void main(String[] args){
        dfs(startX, startY);
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
