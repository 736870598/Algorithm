package com.sunxyaoyu.algorithmlib.test.leetcode;

/**
 * -- 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 * <p>
 * Created by sunxy on 2018/8/21 0021.
 */
public class LeetCode_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode newList = null;
            ListNode next = null;
            while (l1 != null || l2 != null){
                if (newList == null){
                    newList = new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) );
                    next = newList;
                }else{
                    next.next = new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) );
                    next = next.next;
                }
                if (l1 != null){
                    l1 = l1.next;
                }
                if (l2 != null){
                    l2 = l2.next;
                }
            }
            return checkListNode(newList);




//            int num1 = listNode2Num(l1);
//            int num2 = listNode2Num(l2);
//            int count = num1 + num2;
//            return num2ListNode(count);
        }

        private ListNode checkListNode(ListNode newListNode){
            ListNode l = newListNode;
            while (l != null){
                if (l.val >= 10){
                    l.val = l.val - 10;
                    if (l.next == null){
                        l.next = new ListNode(1);
                    }else{
                        l.next.val = l.next.val + 1;
                    }
                }
                l = l.next;
            }
            return newListNode;
        }

        private int listNode2Num(ListNode l){
            int i = 0;
            int num = 0;
            while(l != null){
                num += l.val * Math.pow(10,i);
                i++;
                l = l.next;
            }
            return num;
        }

        private ListNode num2ListNode(int num){
            int length = String.valueOf(num).length();
            ListNode l = null;
            for(int i = 0; i < length; i++){
                int x = (int) (num % Math.pow(10, i+1) / Math.pow(10, i));
                if(l == null){
                    l = new ListNode(x);
                }else{
                    addVal(l, x);
                }
            }
            return l;
        }

        private void addVal(ListNode l, int val){
            ListNode next = l;
            while (next.next != null){
                next = next.next;
            }
            next.next = new ListNode(val);
        }
    }

    public static void main(String[] a){
        Solution solution = new Solution();
        ListNode listNode1 = solution.num2ListNode(342);
        ListNode listNode2 = solution.num2ListNode(465);
        ListNode l = solution.addTwoNumbers(listNode1, listNode2);
        int x = solution.listNode2Num(l);
        System.out.println(x);
//        [1999999999]

    }

}
