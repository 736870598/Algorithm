package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * -- 两个排序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * Created by sunxy on 2018/8/23 0023.
 */
public class LeetCode_4 {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 1. 合并数组
        int length1 = nums1.length;
        int length2 = nums2.length;
        int titleLength = length1 + length2;
        //中位数位置
        int countIndex = titleLength/2;
        int[] nums = new int[titleLength];
        int index1 = 0;
        int index2 = 0;
        //只是取中位数，后面的没必要取了。其实前面的也没有必要取。
        for (int i = 0; i <= countIndex; i++) {

            if (index1 == length1){
                //1里的放完了。剩下的把2里的依次放进去
                nums[i] = nums2[index2++];
            }else if(index2 == length2){
                //2里的放完了。剩下的把1里的依次放进去
                nums[i] = nums1[index1++];
            }else{
                if (nums1[index1] > nums2[index2]){
                    //2里的小。放2里的
                    nums[i] = nums2[index2++];
                }else{
                    nums[i] = nums1[index1++];
                }
            }
        }

        // 2. 取中位数
        boolean isO = titleLength % 2 == 0;
        if (isO){
            return ( nums[countIndex] + nums[countIndex-1] ) / 2.0f;
        }else{
            return nums[countIndex];
        }
    }

    public static void main(String[] s){
        int[] num1 = {};
        int[] num2 = {2,3};

        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.print("medianSortedArrays -> " + medianSortedArrays);
    }

}
