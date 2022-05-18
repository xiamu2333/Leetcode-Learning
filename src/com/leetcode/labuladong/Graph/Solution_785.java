package com.leetcode.labuladong.Graph;

public class Solution_785 {
//    判断是否是二分图，输入为邻接矩阵

    boolean[] visited;
    boolean[] colors;
    boolean isBi;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        colors = new boolean[n];
        isBi = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                travers(graph,i);
            }
        }

        return isBi;
    }
    private void travers(int[][] graph, int curid){
        visited[curid] = true;
        for (int next : graph[curid]) {
            if (!visited[next]){
                colors[next] = !colors[curid];
                travers(graph,next);
            }else {
                if (isBi){
                    isBi = colors[curid]^colors[next];
                }
            }
        }
    }
}
