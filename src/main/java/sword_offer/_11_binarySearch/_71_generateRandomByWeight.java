package src.main.java.sword_offer._11_binarySearch;

// 根据数组的权重，生成随机数的下标

import java.util.Random;

public class _71_generateRandomByWeight {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Weight weight = new Weight(nums);
        for (int i = 0; i < 10; i++) {
            System.out.println(weight.generateRandom());
        }
    }
}

/*
    使用二分查找
        1）求和生成另外一个辅助数组：{1,2,3,4}----》{1,3,6,10}
        2）在0——total中生成一个随机数 k
        3）在辅助数组中，使用二分查找找到 k对应的数-----》找到第一个大于k的数
        [0,1)->0
        [1,3)->1
        [3,6)->2
        [6,10)->3
 */
class Weight{
    private int[] sums; // 辅助数组sums
    private int total;

    public Weight(int[] arr){
        sums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            total+=arr[i];
            sums[i] = total;
        }
    }

    // 生成随机数，并使用二分查找
    public int generateRandom(){
        // 先生成一个随机数
        Random r = new Random();
        int k = r.nextInt(total); // 包括0
        // 使用二分法找到k对应数组中的数，找到第一个大于k的数
        int left = 0;
        int right = sums.length;
        while (left<=right){
            int mid = (left+right)/2;
            if(sums[mid]>k){
                if(mid==0 || sums[mid-1]<=k){
                    // 注意是返回下标
                    System.out.println("k="+k+"  i="+mid);
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return -1;
    }
}
