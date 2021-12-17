# 回溯算法基本思想

1. 适用：求解搜索问题和优化问题

2. 搜索空间：树，结点对应部分解向量，可行解在树叶上

3. 搜索过程：采用系统的方法隐含遍历搜索树

4. 搜索策略：深度优先，宽度优先，函数优先，宽深结合等

5. 结点分支判定条件：满足约束条件，分支扩张解向量; 不满足约束条件，**回溯**到该结点的父结点（backtracking得名）

6. 结点状态：动态生成

   白结点 (尚未访问)

   灰结点(正在访问该结点为根的子树)

   黑结点(该结点为根的子树遍历完成)

7. 存储：当前路径

# 回溯算法适用条件

多米诺性质

# 设计步骤

1. 定义解向量和每个分量的取值范围: 解向量为 < x1, x2, …,xn>, 确定$X_i$的取值集合 Xi, i=1,2,…, n. 
2. 在 <x1,x2,…,xk-1> 确定如何计算 $X_k$取值集合 Sk,  Sk⊆Xk
3. 确定结点儿子的排列规则
4. 判断是否满足多米诺性质
5. 确定每个结点分支的约束条件
6. 确定搜索策略: 深度优先, 宽度优先等
7. 确定存储搜索路径的数据结构

# Practice

[Permutations](https://leetcode.com/problems/permutations/description/)



# Resources

[Backtracking (Ashish's Youtube)](https://www.youtube.com/playlist?list=PLiG0UzlTaKPcnKHm9pNdKFjGOasgvEFC3) 

[Using backtracking to find all possible permutations in a string](https://cs.stackexchange.com/questions/80223/using-backtracking-to-find-all-possible-permutations-in-a-string)

⭐️[A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partioning)](https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning)


