#BFS总结
对应的题目有：
- [开锁](https://leetcode-cn.com/problems/open-the-lock/)
- [网络延迟时间](https://leetcode-cn.com/problems/network-delay-time)
- [概率最大路径](https://leetcode-cn.com/problems/path-with-maximum-probability)
- [体力最小消耗路径](https://leetcode-cn.com/problems/path-with-minimum-effort)

##1.基本BFS框架
**思路**
- 由二叉树为例，BFS即为层序遍历，用队列实现。
- 由于要记录每一层的长度，才能实现按层遍历，因此每次遍历前记录要遍历的层的长度。
- 每遍历一层使用count记录层数。
- 记得每个遍历的结点可以设置加入队列的条件，进行剪枝以及防止走回头路。
- 层序遍历不能记录路径

**框架**
~~~java
class BFS {
    //给一个树，最大深度
    public int bfs(Node root){
        int count = 0;  //记录步数
        Queue<Node> queue = new LinkedList<>();//用队列记录下一个要遍历的结点

        queue.offer(root);//先添加头部

        while (!queue.isEmpty()) {
            int sz = queue.size();//实现按层遍历

            for (int i = 0; i < sz; i++) {
                Node temp = queue.poll();

                if (temp.left != null) {
                    queue.add(temp.left);//不为空则加入队列
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            count++;//每遍历一层就加一
        }

        return count;
    }
}
~~~

##2.如果不是单向的，应该不走回头路
**如果对象是图，则需要增加:**
- 记录访问过路径的集合；
~~~java 
HashSet<Integer> visited = new HashSet<>();//记录走过的路
~~~
- 每取出一个节点判断是否是终点，是的话就返回；
- 遍历当前节点相邻的结点，准备作为下一步添加进队列；
- 每往队列中添加下一个路径的时候，进行判断，比如判断是否已走过。

##3.双端搜索
**可以同时从start和end进行搜索，提高效率**
- 可以用HashSet维护两个list，分别从首尾开始搜索；
- 用一个tempList储存遍历这一层时对应的的下一层；
- 结尾时对list1和list2进行交换从，代码复用；
- 详见class Solution_752的开锁问题。

##4.最短路径类问题
**迪杰斯特拉算法**
1. 建立一个数组Distance，维护每个结点到start的距离；
2. 初始距离设置为极大；
3. 从start开始，将与其到相邻的结点的距离信息在Distance中更新；
4. 每次选择未遍历的，且到start最短的一个结点（即Distance中的最小值）；
5. 目前结点到相邻结点路径长度加该节点的Distance与现有的Distance比较，短则更新；
6. 重复4和5直到全部遍历完成，得到所有节点到start的最短距离。

**与2中图的遍历对比**
- 边的权重从1变成了其他值；
- 每次从队列中要取的点是到start最短的点。

**实现的区别**
- 新建一个class用来储存Node的信息：
~~~java
class State{
    int id;         //当前结点的编号
    int distanceFrom;//到start的距离

    Nextnode(int id, double distanceFrom){
        this.id = id;
        this.distanceFrom = distanceFrom;
    }
}
~~~
    - 要注意的是，这里的distanceFrom不一定对应Distance的值，可能在入队后出现更短的路径；
 
 - 使用Priority队列来维护Queue，每次取出distanceFrom最短的；
 - 入队时判断该路径是否比已有的更优；
 - 不用维护visited，因为回头路肯定会变长；
 - 只求到目的终点时，第一次取到id==end的State就可以return了，
 因为此时queue中的所有state都大于等于这个State的distanceFrom。
  



