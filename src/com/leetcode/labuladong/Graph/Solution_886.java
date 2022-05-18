package com.leetcode.labuladong.Graph;

public class Solution_886 {
//    输入的是一组人与人之间相互不喜欢的关系（无向图或双向图）
//    题目给的人的编号是从1开始的
    boolean[] visited;
    boolean[] colors;
    boolean isBi;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n+1];
        colors = new boolean[n+1];
        isBi = true;

        Graph[] graphs = buildeGraph(n,dislikes);

        return isBi;
    }

    private void traverse(Graph[] graphs, int curId){
        if (!isBi) return;

        visited[curId] = true;

        for (Integer integer : graphs[curId].getNext()) {
            if (!visited[integer]){
                colors[integer] = !colors[curId];
                traverse(graphs,integer);
            }
            else {
                isBi = colors[integer] ^ colors[curId];
            }
        }
    }

    private Graph[] buildeGraph(int n, int[][] dislikes){
        Graph[] graphs = new Graph[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graphs[i] = new Graph(i);
        }
        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            graphs[a].addNext(b);
            graphs[b].addNext(a);
        }

        return graphs;
    }
}
