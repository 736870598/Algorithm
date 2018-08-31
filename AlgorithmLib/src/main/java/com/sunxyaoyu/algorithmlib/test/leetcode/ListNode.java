package com.sunxyaoyu.algorithmlib.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * --  LeetCode 中常用的一种数据结构
 * <p>
 * Created by sunxy on 2018/8/31 0031.
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }



    public static ListNode array2List(int[] nums){
        ListNode node = new ListNode(nums[0]);
        ListNode head = node;

        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }

        return node;
    }

    public static void printListNode(ListNode head){
        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public static List listNode2List(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

}
