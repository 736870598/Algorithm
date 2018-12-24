package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * SunXiaoYu on 2018/12/24.
 * mail: sunxiaoyu@hexinpass.com
 */
public class LeetCode_27 {

    public static void main(String[] args){
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int[] nums = new int[]{3,2,2,3};
        int count = removeElement(nums, 2);
        System.out.println("count: " + count);
        for (int i = 0; i < count; i++) {
            System.out.print(" -- " + nums[i]);
        }
    }


    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        if (size == 0) return 0;

        int i = 0;
        for (int j = 0; j < size; j++) {
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
