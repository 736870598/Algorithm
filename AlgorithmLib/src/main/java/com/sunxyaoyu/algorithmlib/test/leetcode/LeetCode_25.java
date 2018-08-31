package com.sunxyaoyu.algorithmlib.test.leetcode;


/**
 * -- k个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 * <p>
 * Created by sunxy on 2018/8/31 0031.
 */
public class LeetCode_25 {

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode current_node = head;
            int count = 0;
            while (current_node != null && count != k) {
                current_node = current_node.next;
                count++;
            }
            if (count == k) {
                current_node = reverseKGroup(current_node, k);/// 递归的解决子问题
                while (count-- > 0) {
                    ListNode temp = head.next;
                    head.next = current_node;
                    current_node = head;
                    head = temp;
                }///最终，该段的所有节点将会截空，head应指向current_node
                head = current_node;
            }
            return head;
        }
    }


    public static void main(String[] str){
        ListNode listNode = ListNode.array2List(new int[]{1, 2, 3, 4, 5});

        Solution solution = new Solution();
        ListNode listNode1 = solution.reverseKGroup(listNode, 2);
        ListNode.printListNode(listNode1);
    }


}
