package com.leetcode.labuladong.Graph;

import java.util.LinkedList;
import java.util.List;

public class Solution_797 {
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        travers(graph,0,path);
        return res;
    }
    private void travers(int[][] graph, int s, List<Integer> path){
        path.add(s);
        int n = graph.length-1;
        if (s == n) res.add(new LinkedList<>(path));
        for (int i : graph[s]) {
            travers(graph,i,path);
        }

        path.remove(path.size()-1);
    }
}
