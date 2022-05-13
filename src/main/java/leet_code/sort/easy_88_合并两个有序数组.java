package src.main.java.leet_code.sort;

/*
    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 */
import java.util.Arrays;

public class easy_88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {3,5,0,0,0};
        int m = 2;
        int[] nums2 = {1,2,6};
        int n = 3;
        merge_six(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return ;
        }
        // 采用归并排序的思想; 定义三个指针，和一个辅助数组
        int p1=0;
        int p2=0;
        int i=0;
        int[] assist = new int[m+n];
        while (p1<m && p2<n){
            if(nums1[p1]<nums2[p2]){
                assist[i++] = nums1[p1++];
            }else {
                assist[i++] = nums2[p2++];
            }
        }
        while (p1<m){
            assist[i++] = nums1[p1++];
        }
        while (p2<n){
            assist[i++] = nums2[p2++];
        }
        if (m + n >= 0) System.arraycopy(assist, 0, nums1, 0, m + n);
    }
    public static void merge_six(int[] nums1, int m, int[] nums2, int n){
        int p1 = m-1;
        int p2 = n-1;
        int i = m+n-1;  // 定义数组索引

        while (p1>=0 && p2>=0){
            nums1[i--] = nums1[p1]>nums2[p2] ? nums1[p1--]: nums2[p2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
