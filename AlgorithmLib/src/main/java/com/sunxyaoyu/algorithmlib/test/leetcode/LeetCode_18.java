package com.sunxyaoyu.algorithmlib.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * --四数之和
 * https://leetcode-cn.com/problems/4sum/description/
 * <p>
 * Created by sunxy on 2018/8/29 0029.
 */
public class LeetCode_18 {

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> list = new ArrayList<>();
            if(nums == null || nums.length < 4){
                return list;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i+1; j < nums.length - 2; j++) {
                    if (target > 0 && nums[i] + nums[j] > target){
                        continue;
                    }
                    int k = j+1;
                    int m = nums.length-1;
                    while (k < m){
                        int sum = nums[i] + nums[j] + nums[k] + nums[m];
                        if (sum == target) {
                            isCon(list, int2List( nums[i], nums[j], nums[k], nums[m]));
//                            list.add(int2List( nums[i], nums[j], nums[k], nums[m]));
                        }
                        if(sum > target){
                            m--;
                        }else{
                            k++;
                        }
                    }

                }
            }
            return list;
        }

        private List<Integer> int2List(int i, int j, int k, int m){
            List<Integer> result = new ArrayList<>();
            result.add(i);
            result.add(j);
            result.add(k);
            result.add(m);
            return result;
        }

        private void isCon(List<List<Integer>> lists, List<Integer> list){
            if (!lists.contains(list)){
                lists.add(list);
            }
        }
    }

    public static void main(String[] s){
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
//        int[] nums = {1, 0, -1, 0, -2, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(nums, -11);
        System.out.println("size = " + lists.size());
        for (List<Integer> list : lists) {
            System.out.print(list + " , ");
        }


    }

}
