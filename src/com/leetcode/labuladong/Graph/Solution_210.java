package com.leetcode.labuladong.Graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_210 {
    class Graph{
        private int id;
        List<Integer> nextNode;
        Graph(int id){
            this.id = id;
            this.nextNode = new LinkedList<>();
        }

        public int getId() {
            return id;
        }
    }

    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;

    List<Integer> lastOrder;
    public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {
        Graph[] graph = new Graph[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Graph(i);
        }

        for (int[] prerequisite : prerequisites) {
            int thisid = prerequisite[0];
            int preid = prerequisite[1];
            graph[preid].nextNode.add(thisid);
        }

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        hasCycle = false;
        lastOrder = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            traverse(graph,i);
        }

        if (hasCycle){
            return new int[0];
        }

        Collections.reverse(lastOrder);
        int[] preOrder = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            preOrder[i] = lastOrder.get(i);
        }

        return preOrder;

    }
    private void traverse(Graph[] graph, int s){
        if (onPath[s]){
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (Integer integer : graph[s].nextNode) {
            traverse(graph,integer);
        }
        lastOrder.add(s);
        onPath[s] = false;
    }

    public int[] findOrder_BFS(int numCourses, int[][] prerequisites){
        Graph[] graph = new Graph[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Graph(i);
        }

        for (int[] prerequisite : prerequisites) {
            int fromid = prerequisite[1];
            int toid = prerequisite[0];
            graph[fromid].nextNode.add(toid);
            inDegree[toid]++;
        }

        Queue<Graph> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                queue.add(graph[i]);
                res.add(i);
            }
        }

        while (!queue.isEmpty()){
            Graph cur = queue.poll();
            for (Integer integer : cur.nextNode) {
                inDegree[integer]--;
                if (inDegree[integer] == 0){
                    queue.add(graph[integer]);
                    res.add(integer);
                }
            }
        }

        if (res.size() != numCourses){
            return new int[0];
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = res.get(i);
        }

        return order;
    }
}
