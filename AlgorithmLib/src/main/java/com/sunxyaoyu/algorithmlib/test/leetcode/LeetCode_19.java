package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * --19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 * <p>
 * Created by sunxy on 2018/8/31 0031.
 */
public class LeetCode_19 {


    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null){
                return null;
            }
            ListNode firstNode = null;
            ListNode secondNode = head;
            int i = 0;
            while (secondNode != null){
                if (++i > n){
                    if(firstNode == null){
                        firstNode = head;
                    }else{
                        firstNode = firstNode.next;
                    }
                }
                secondNode = secondNode.next;
            }

            //first的下一个节点就是要删除的
            if (firstNode == null){
                head = head.next;
            }else{
                firstNode.next = firstNode.next.next;
            }

            return head;
        }
    }




    public static void main(String[] s){

        ListNode node = ListNode.array2List(new int[]{1, 2,3,4,5});

        Solution solution = new Solution();
        ListNode node1 = solution.removeNthFromEnd(node, 2);
        ListNode.printListNode(node1);

    }

}
