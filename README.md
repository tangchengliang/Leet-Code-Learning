# Leet-Code-Learning
刷题学习

## Leet Code
  ### [46 全排列](https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/)
  难度：中等  
      1）设置记录是否使用这个元素，used[i]=false  
      2) 设置中间结果 path，用Deque双端队列
      3) 设置接收结果res  
     DFS--->  
      4) 设置结束条件，一般是递归层次到达数组的长度（depth==len)，此时计数count或者记录这个组合res.add(new ArrayList(path)),因为path是一个引用，所以这里要对path进行拷贝  
      5) for用于循环遍历每个元素  
      6）添加并标记
      7）dfs  
      8）回溯      [code](https://github.com/tangchengliang/Leet-Code-Learning/blob/main/src/main/java/dfs/Leet_46_permutations.java)
 
 ## Lan Qiao
  [12届-砝码称重](http://lx.lanqiao.cn/problem.page?gpid=T2895)
  
