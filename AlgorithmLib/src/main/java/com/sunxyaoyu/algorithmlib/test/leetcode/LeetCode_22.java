package com.sunxyaoyu.algorithmlib.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * - https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * Created by Sunxy on 2018/12/23.
 */
public class LeetCode_22 {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        create(list, "", 0, 0, 2);
        for (String s : list) {
            System.out.println(s);
        }

    }

    public static void create(List<String> list, String str, int count1, int count2, int count){
        if (str.length() == count * 2){
            list.add(str);
            return;
        }

        if (count1 < count){
            create(list, str + "(", count1+1, count2, count);
        }
        if (count2 < count1){
            create(list, str + ")", count1, count2+1, count);
        }
    }
}
