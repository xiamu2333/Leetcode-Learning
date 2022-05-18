package com.leetcode.labuladong.BFS;

import java.util.HashSet;
import java.util.Set;


//开锁问题，BFS,用了双端搜索
public class Solution_752 {
    public int openLock(String[] deadends, String target) {
        int count = 0;
        HashSet<String> deads = new HashSet<>();    //set储存死区；
        HashSet<String> visiteds = new HashSet<>(); //储存访问过的结点，防止回头；
        for (String deadend : deadends) {
            deads.add(deadend);
        }

        String start = "0000";
        Set<String> list1 = new HashSet<>();
        Set<String> list2 = new HashSet<>();    //双向搜索
        list1.add(start);
        list2.add(target);

        while (!list1.isEmpty() && !list2.isEmpty()){
            Set<String> templist = new HashSet<>();
            for (String s : list1) {
                if(list2.contains(s)) return count;
                if (deads.contains(s)) continue;
                visiteds.add(s);

                String[] adjs = adj(s);
                for (String nextlock : adjs) {
                    if (visiteds.contains(nextlock)) continue;
                    templist.add(nextlock);
                }
            }
            count++;
            list1 = list2;
            list2 = templist;
        }

        return -1;
    }
    public String[] adj(String s){
        String[] res = new String[8];
        char[] temp = s.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            char now = temp[i];
            if(now == '9'){
                temp[i] = '0';
            }else {
                temp[i]++;
            }
            res[0 + i*2] = String.valueOf(temp);
            temp[i] = now;

            if (now == '0'){
                temp[i] = '9';
            }else {
                temp[i]--;
            }
            res[1 + i*2] = String.valueOf(temp);
            temp[i] = now;
        }
        return res;
    }
}
