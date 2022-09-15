package src.main.java.sword_offer._08_tree;

import java.util.TreeSet;

/*
    寻找 索引和值之差的绝对值，都小于指定值的数
 */
public class _57_treeSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        boolean result = treeSetTest(arr, 3, 0);
        System.out.println(result);
    }

    private static boolean treeSetTest(int[] arr, int k, int t) {
        // k是索引差，t是值差
        TreeSet<Integer> treeSet = new TreeSet<>();
        // 遍历链表，将数存入treeSet
        for(int i=0;i<arr.length;i++){
            // 先找到treeSet中小于等于arr[i]的最大数
            Integer lower = treeSet.floor(arr[i]);
            // 注意求解的是绝对值，条件需要多理解一下
            // |前面的数-后面的数|>=t

            if(lower!=null && arr[i]-lower<=t){
                return true;
            }
            // 先找到treeSet中大等于arr[i]的最小数
            Integer upper = treeSet.ceiling(arr[i]);
            if(upper!=null && upper-arr[i]<=t){
                return true;
            }
            treeSet.add(arr[i]);

            // 因为i-0=i，所有注意这里索引为0时
            // 当i>=k时，才依次减去TreeSet中的数
            if(i>=k){
                treeSet.remove(arr[i-k]);
            }
        }
        return false;
    }
}
