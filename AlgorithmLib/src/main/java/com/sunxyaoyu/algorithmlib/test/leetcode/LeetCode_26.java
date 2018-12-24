package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * SunXiaoYu on 2018/12/24.
 * mail: sunxiaoyu@hexinpass.com
 */
public class LeetCode_26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] nums = new int[]{1, 1, 2};
        int i = removeDuplicates(nums);
        System.out.println("i : " + i);
        for (int i1 = 0; i1 < i; i1++) {
            System.out.print(" - " + nums[i1]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        int i = 0;
        for (int j = 1; j < size; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
