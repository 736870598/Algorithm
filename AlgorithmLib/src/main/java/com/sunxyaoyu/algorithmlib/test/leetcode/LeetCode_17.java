package com.sunxyaoyu.algorithmlib.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * --电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 * <p>
 * Created by sunxy on 2018/8/29 0029.
 */
public class LeetCode_17 {

    public static void main(String[] s){
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("");
        System.out.print(strings.toString());
    }


    static class Solution {

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.equals("")){
                return result;
            }
            List<String[]> lists = new ArrayList<>();
            char[] chars = digits.toCharArray();
            for (char aChar : chars) {
                String[] strings = num2Letters(aChar);
                if (strings != null){
                    lists.add(strings);
                }
            }
            add(lists, result, 0, "");
            return result;
        }

        private String[] num2Letters(char c){
            switch (c){
                case 50:
                    return new String[]{"a","b","c"};
                case 51:
                    return new String[]{"d","e","f"};
                case 52:
                    return new String[]{"g","h","i"};
                case 53:
                    return new String[]{"j","k","l"};
                case 54:
                    return new String[]{"m","n","o"};
                case 55:
                    return new String[]{"p","q","r", "s"};
                case 56:
                    return new String[]{"t","u","v"};
                case 57:
                    return new String[]{"w","x","y","z"};
            }
            return null;
        }

        private void add(List<String[]> lists, List<String> result, int index, String str){
            for (String s : lists.get(index)) {
                if (index == lists.size()-1){
                    result.add(str+s);
                }else{
                    add(lists, result, index+1, str+s);
                }
            }
        }
    }
}
