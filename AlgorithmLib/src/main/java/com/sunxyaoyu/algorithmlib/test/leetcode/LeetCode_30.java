package com.sunxyaoyu.algorithmlib.test.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * - 30. 与所有单词相关联的字串
 *  https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 * <p>
 * Created by Sunxy on 2018/9/1.
 */
public class LeetCode_30 {

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> indexList = new ArrayList<>();
            for (String word : words) {
                int index = s.indexOf(word);
                if (index == -1){
                    continue;
                }
                String newStr = s.substring(index + word.length());
                while (true){
                    List<String> list = new ArrayList<>();
                    list.add(word);
                    if (nextIsSame(newStr, words, list)){
                        indexList.add(index);
                    }
                    int newIndex = newStr.indexOf(word);
                    if (newIndex == -1){
                        break;
                    }
                    index +=  word.length() + newIndex;
                    newStr = newStr.substring(newIndex + word.length());
                }

            }
            return indexList;
        }


        private boolean nextIsSame(String newStr, String[] words, List<String> list) {
            if (words.length == list.size()){
                return true;
            }
            for (String word : words) {
                if (list.contains(word)){
                    continue;
                }
                if (newStr.startsWith(word)){
                    list.add(word);
                    return nextIsSame(newStr.substring(word.length()), words, list);
                }

            }
            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<Integer> barfoothefoobarman = s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        System.out.println(barfoothefoobarman);
    }

}
