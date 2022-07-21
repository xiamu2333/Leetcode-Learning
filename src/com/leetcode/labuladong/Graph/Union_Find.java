package com.leetcode.labuladong.Graph;

public class Union_Find {
    private int number;     //记录连通图数量，初始无连通时，值为节点数
    private int[] parent;

    public Union_Find(int number) {
        this.number = number;
        parent = new int[number];

        for (int i = 0; i < number; i++) {
            parent[i] = i;
        }
    }

//    辅助数组，用来查找某节点的根节点。
//    在辅助函数find中进行树的压缩。
    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

//    将结点p和q进行连通，并且将连通数量减一
//    若两个节点已经连通，则直接返回；
    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);

        if (rootp == rootq) return;
        parent[p] = rootq;
        number--;
    }

//    用于返回两个点是否已经连通
    public boolean connected(int p, int q){
        int rootp = find(p);
        int rootq = find(q);

        return rootp == rootq;
    }

//    返回当前连通图的数量
    public int count() {
        return number;
    }
}
