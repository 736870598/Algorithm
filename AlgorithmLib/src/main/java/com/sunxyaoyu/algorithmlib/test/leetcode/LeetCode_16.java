package com.sunxyaoyu.algorithmlib.test.leetcode;


import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/description/
 */
public class LeetCode_16 {


	public static int threeSumClosest(int[] nums, int target) {
		if(nums == null){
			return 0;
		}
		Arrays.sort(nums);
		int minSum = nums[0] + nums[1] + nums[nums.length-1];
		for(int i = 0; i < nums.length-2; i++){
			int j = i+1, k = nums.length-1;
			while(j < k){
				int sum = nums[i] + nums[j] + nums[k];
				if(sum > target){
					k--;
				}else{
					j++;
				}
				if(Math.abs(sum-target) < Math.abs(minSum-target)){
					minSum = sum;
				}
			}
		}
		return minSum;
	}
	

	public static void main(String[] args){
//		int[] nums = {1,1,-1,-1,3};
		int[] nums = {-1,2,1,-4};
		int min = threeSumClosest(nums, -1);
		System.out.print("min -> " + min);

	}

}
