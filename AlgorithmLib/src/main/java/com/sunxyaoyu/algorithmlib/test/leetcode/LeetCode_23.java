package com.sunxyaoyu.algorithmlib.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * -- 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 * <p>
 * Created by sunxy on 2018/8/30 0030.
 */
public class LeetCode_23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<Integer> allList = new ArrayList<>();
            for (ListNode node : lists) {
                nodeAddList(allList, node);
            }
            Collections.sort(allList);
            return list2Node(allList);
        }


        private void nodeAddList(List<Integer> allList, ListNode node){
            while (node != null){
                allList.add(node.val);
                node = node.next;
            }
        }

        private ListNode list2Node(List<Integer> allList){
            if (allList == null || allList.isEmpty()){
                return null;
            }

            ListNode headNode = null;
            ListNode nextNode = null;

            for (Integer integer : allList) {
                if (headNode == null){
                    headNode = new ListNode(integer);
                    nextNode = headNode;
                }else{
                    nextNode.next = new ListNode(integer);
                    nextNode = nextNode.next;
                }
            }

            return headNode;
        }


        public ListNode mergeKLists2(ListNode[] lists) {
            ListNode insertNode = null;
            for (ListNode node : lists) {
                ListNode nextNode = node;
                while (nextNode != null){
                    insertNode = insertIntoNode(insertNode, nextNode.val);
                    nextNode = nextNode.next;
                }
            }
            return insertNode;
        }

        private ListNode insertIntoNode(ListNode node, int x){
            if (node == null){
                node = new ListNode(x);
                return node;
            }

            ListNode newNode = new ListNode(x);
            ListNode proNode = node;

            //比头结点小
            if (x < proNode.val){
                newNode.next = proNode;
                return newNode;
            }

            //只有一个节点
            if (proNode.next == null){
                proNode.next = newNode;
                return proNode;
            }

            while (proNode.next != null){
                if (x < proNode.next.val){
                    //插入到proNode 和 proNode.next之间
                    newNode.next = proNode.next;
                    proNode.next = newNode;
                    return node;
                }
                proNode = proNode.next;

            }
            proNode.next = newNode;
            return node;
        }
    }
}
