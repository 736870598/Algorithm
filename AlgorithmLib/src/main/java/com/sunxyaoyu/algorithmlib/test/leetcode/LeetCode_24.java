package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 *  24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * SunXiaoYu on 2018/12/24.
 * mail: sunxiaoyu@hexinpass.com
 */
public class LeetCode_24 {

    public static void main(String[] args){

        ListNode listNode = ListNode.array2List(new int[]{1,2,3,4,5,6});
        ListNode node = swapPairs(listNode);
        ListNode.printListNode(node);

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode newListNode = new ListNode(0);
        newListNode.next = head;
        ListNode newHead = newListNode;
        while (changeListNode(newHead)){
            newHead = newHead.next;
            newHead = newHead.next;
        }

        return newListNode.next;
    }

    /**
     * 交换该节点后俩个节点
     */
    public static boolean changeListNode(ListNode listNode){
        ListNode node1 = listNode.next;
        if (node1 == null){
            return false;
        }
        ListNode node2 = node1.next;
        if (node2 == null){
            return false;
        }

        listNode.next = node2;
        node1.next = node2.next;
        node2.next = node1;

        return true;
    }
}
