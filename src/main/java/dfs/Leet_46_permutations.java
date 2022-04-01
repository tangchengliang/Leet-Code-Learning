package src.main.java.dfs;

import java.util.*;

public class Leet_46_permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int len = nums.length;
        // 创建一个res , 用于接收排列结果
        List<ArrayList<Integer>> res = new ArrayList<>();
        //  Deque 是一个双端队列（两端都可进出），代替Stack
        Deque<Integer> path = new ArrayDeque<>();
        // 创建一个boolean, 记录该值是否被遍历， 默认为false
        boolean[] used = new boolean[len];
        // 递归
        dfs(nums, len, 0, path, used, res);
        System.out.println(res);

    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<ArrayList<Integer>> res) {
        if(depth==len){
            /**
             *  path 这是添加一个引用，在深度优先遍历结束后，path 回到根节点，成为一个空列表
             *  因此,在这里需要对path进行拷贝
             *  new ArrayList<>(path)
             */
            res.add(new ArrayList<>(path));
            return;
        }

        // 递归分支
        for (int i = 0; i < len; i++) {
            if(used[i]){
                continue;
            }
            // 由于path是一个栈，所有添加到末尾
            path.addLast(nums[i]);
            used[i] = true; //该数被使用，赋值为true
            // 继续递归
            dfs(nums, len, depth+1, path, used, res);
            // 递归完后，需要回溯
            path.removeLast();
            used[i] = false;

        }

    }
}
