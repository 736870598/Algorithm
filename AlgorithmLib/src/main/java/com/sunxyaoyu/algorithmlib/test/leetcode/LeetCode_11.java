package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * -- 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 * <p>
 * Created by sunxy on 2018/8/24 0024.
 */
public class LeetCode_11 {

    //暴力法
//    public static int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[i], height[j]);
//                maxArea = Math.max(maxArea, area);
//            }
//        }
//        return maxArea;
//    }


    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length-1;
        while (l < r){
            maxArea = Math.max(maxArea, (r-l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }


    public static void main(String[] str){
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {01,2};
        int maxArea = maxArea(height);
        System.out.print("maxArea -> " + maxArea);
    }

}
