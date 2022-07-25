package src.main.java.sword_offer._08_tree;

import java.util.HashMap;
import java.util.Map;

import static src.main.java.sword_offer._08_tree._48_serialize.deserialize;

public class _50_pathSum {
    public static void main(String[] args) {
        String nodeStr = "5,2,1,#,#,6,#,#,4,3,#,#,7,#,#";
        TreeNode root = deserialize(nodeStr);
        int result = pathSum(root, 8);
        System.out.println(result);
    }

    private static int pathSum(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化map值
        map.put(0,1);
        return pathSumDfs(root, k, map, 0);
    }

    private static int pathSumDfs(TreeNode root, int k, Map<Integer, Integer> map, int path) {
        if(root==null){
            return 0;
        }
        path+=root.val;
        int count = map.getOrDefault(path-k,0);
        map.put(path,map.getOrDefault(path,0)+1);

        count += pathSumDfs(root.left, k, map, path);
        count += pathSumDfs(root.right, k, map, path);

        // 回到根节点时，要将path去除，防止再计算
        map.put(path, map.get(path)-1);

        return count;
    }
}
