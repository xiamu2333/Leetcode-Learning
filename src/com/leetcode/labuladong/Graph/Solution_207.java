package com.leetcode.labuladong.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_207 {
    static boolean isCycle;
    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0) return true;
        GraphNode[] graph = tranToGraph(numCourses,prerequisites);
        boolean[] visited = new boolean[numCourses];    //boolean的默认值为false
        boolean[] onPath = new boolean[numCourses];
        isCycle = false;

        for (int i = 0; i < numCourses; i++) {
            trave_DFS(visited,onPath,graph,i);
        }

        return !isCycle;
    }
    private void trave_DFS(boolean[] visited,boolean[] onPath,GraphNode[] graph,int s){
        if (onPath[s]){
            isCycle = true;
        }
        if (visited[s] || isCycle){
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (Integer nextNode : graph[s].NextNodes) {
            trave_DFS(visited,onPath,graph,nextNode);
        }
        onPath[s] = false;
    }

    public boolean canFinish_BFS(int numCourses, int[][] prerequisites){
        if (numCourses == 1 || prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        Queue<GraphNode> nodeQueue = new LinkedList<>();
        int count = 0;

        GraphNode[] graph = tranToGraph(numCourses,prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                nodeQueue.add(graph[i]);
                count++;
            }
        }

        while (!nodeQueue.isEmpty()){
            GraphNode cur = nodeQueue.poll();
            for (Integer nextNode : cur.NextNodes) {
                inDegree[nextNode]--;
                if (inDegree[nextNode] == 0){
                    nodeQueue.add(graph[nextNode]);
                    count++;
                }
            }
        }

        return count == numCourses;
    }


    private GraphNode[] tranToGraph(int numCourses, int[][] prerequisites){
        GraphNode[] graph = new GraphNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new GraphNode(i);
        }
        for (int[] ints : prerequisites) {
            int thisId = ints[1];
            int nextID = ints[0];
            graph[thisId].NextNodes.add(nextID);
        }
        return graph;
    }
}

class GraphNode {
    private int id;
    public List<Integer> NextNodes;

    public GraphNode(int id) {
        this.id = id;
        NextNodes = new LinkedList<>();
    }

    public int getId() {
        return id;
    }
}
