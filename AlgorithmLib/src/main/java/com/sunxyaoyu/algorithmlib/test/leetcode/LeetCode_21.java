package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * 21. 合并两个有序链表
 * - https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>
 * Created by Sunxy on 2018/12/23.
 */
public class LeetCode_21 {

    public static void main(String[] args){
        ListNode listNode1 = ListNode.array2List(new int[]{5});
        ListNode listNode2 = ListNode.array2List(new int[]{1, 3, 4});

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        ListNode.printListNode(listNode);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode next = listNode;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                next.next = new ListNode(l1.val);
                next = next.next;
                l1 = l1.next;
            }else{
                next.next = new ListNode(l2.val);
                next = next.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            next.next = l2;
        }else{
            next.next = l1;
        }
        return listNode.next;
    }
}
