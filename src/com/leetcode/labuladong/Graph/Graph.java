package com.leetcode.labuladong.Graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
//    图节点的定义以及相应方法
    private int id;
    private List<Integer> nextNode;
    Graph(int id){
        this.id = id;
        this.nextNode = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public List<Integer> getNext(){
        return nextNode;
    }

    public void addNext(Graph nextgraph){
        nextNode.add(nextgraph.getId());
    }
    public void addNext(int nextid){
        nextNode.add(nextid);
    }

    public void remove(int removeid){
        nextNode.remove(removeid);
    }

    public static Graph[] buildGraph(int[][] graph){
//        用邻接矩阵构成Graph数组
        int n = graph.length;
        Graph[] res = new Graph[n];
        for (int i = 0; i < n; i++) {
            res[i] = new Graph(i);
            for (int next : graph[i]) {
                res[i].addNext(next);
            }
        }
        return res;
    }
}
