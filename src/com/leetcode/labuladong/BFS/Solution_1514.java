package com.leetcode.labuladong.BFS;

import java.util.*;

//最大概率路径，迪杰斯特拉算法，BFS问题，记录深度（长度）
public class Solution_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        State[] states = new State[n];
        for(int i = 0; i < n; i++){
            states[i] = new State(i);
        }
        for(int i = 0; i < edges.length; i++){
            int cur = edges[i][0];
            int next = edges[i][1];
            double wight = succProb[i];
            states[cur].putNext(next , wight);
            states[next].putNext(cur , wight);
        }

        Queue<State> queue = new PriorityQueue<>();
        double[] dis = new double[n];
        Arrays.fill(dis, Integer.MIN_VALUE);
        dis[start] = 1;
        states[start].distanceFrom = 1;
        queue.offer(states[start]);

        while(!queue.isEmpty()){
            State cur = queue.poll();
            if(cur.node == end) return cur.distanceFrom;
            if(cur.distanceFrom < dis[cur.node]) continue;

            for(Nextnode nend : cur.nextnodes){
                if(dis[nend.nextnode] < nend.succ * dis[cur.node]){
                    dis[nend.nextnode] = nend.succ * dis[cur.node];
                    states[nend.nextnode].distanceFrom = nend.succ * dis[cur.node];
                    queue.offer(states[nend.nextnode]);
                }
            }
        }
        return 0;


    }
}

class State implements Comparable {
    int node;
    List<Nextnode> nextnodes;

    double distanceFrom;
    State(int node){
        this.node = node;
        this.nextnodes = new LinkedList<>();
    }
    public void putNext(int nextnode , double succ){
        nextnodes.add(new Nextnode(nextnode , succ));
    }
    public int compareTo(Object o){
        if(((State)o).distanceFrom - this.distanceFrom < 0) return -1;
        else if(((State)o).distanceFrom - this.distanceFrom == 0) return 0;
        else return 1;
    }
}

class Nextnode{
    int nextnode;
    double succ;

    Nextnode(int nextnode, double succ){
        this.nextnode = nextnode;
        this.succ = succ;
    }
}
