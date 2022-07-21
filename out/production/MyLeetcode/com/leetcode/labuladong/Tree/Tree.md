#跟着labuladong刷二叉树
二叉树的两种遍历：
- DFS；
~~~java
class searchTree{
    void Search(TreeNode root){
        Search(root.left);
        Search(root.rigth);
    }
}
~~~
- BFS。

对于DFS中，有三种遍历顺序，即树的
前序遍历，中序遍历和后序遍历。

**指的是要执行动作的代码段放在哪个位置**

二叉树解题的两种思路：
- 一次遍历得到结果：回溯法；
- 分解为子问题得到结果：动态规划。 

**注意：**

    前序位置的代码只能从函数参数中获取父节点传递来的数据，
    而后序位置的代码不仅可以获取参数数据，
    还可以获取到子树通过函数返回值传递回来的数据。
    
##1.二叉树
- **二叉树的难点在于，
如何将问题细分为每个结点该做的事**

    - 先明确每个递归要干什么；
    - 明确定义之后设计相应的方法；
    - 相信这个方法和定义，不用管具体实现；
    - 将方法放到合适的前中后序的位置。

- **快速排序：**
    - 是二叉树的前序遍历
    - 先把一个数排好，再排剩下的数

- **归并排序：**
    - 是二叉树的后序遍历；
    - 先排好左右数组，再合并；
    - 数组某元素后有多少元素。。。的问题，都可用归并排序简化：
        - 在merge种进行操作；
        - 可以求逆序对；
        - 求逆序元素个数（letcode的315题）。

注意：区间和可简化为前缀和之差！！！

##2.二叉搜索树（Binary Search Tree，BST）
- **基本性质：**
    - 二叉搜索树的左子树比根节点小，右子树都比根节点大；
    - 中序遍历的结果是有序的；
    - 与快速排序的关联。
- **进阶：**
    - 中序遍历可以升序打印结点的值；
    ~~~java
  class solution{
      public void traverse(TreeNode root) {
          if (root == null) return;
          traverse(root.left);
          // 中序遍历代码位置
          print(root.val);
          traverse(root.right);
      }
  }
  ~~~
  - 更改递归顺序就能降序打印结点的值；
      ~~~java
    class solution{
        public void traverse(TreeNode root) {
            if (root == null) return;
            // 先递归遍历右子树
                traverse(root.right);
                // 中序遍历代码位置
                print(root.val);
                // 后递归遍历左子树
                traverse(root.left);
        }
    }
    ~~~
  - 可以通过使用辅助函数，增加函数的参数列表，在参数中携带额外信息，将约束传递给所有子树。如判断二叉树是否为二叉搜索树：
    ~~~java
      class solution{
        boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }
        
        /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
        boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            // base case
            if (root == null) return true;
            // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
            return isValidBST(root.left, min, root) 
                && isValidBST(root.right, root, max);
        }
      }
    ~~~
    - 二叉搜索树的增删查改；
    - 注意递归，DFS的时候可能有重复子问题，用用数组记录结果进行去重（动态规划）。

注意：后序遍历的重点是，需要的值能通过左右子树得出。
[1373. 二叉搜索子树的最大键值和](https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/)

##3.其他问题转化为树的问题
- [为一个数据结构设计迭代器](https://mp.weixin.qq.com/s/uEmD5YVGG5LHQEmJQ2GSfw)