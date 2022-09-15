package src.main.java.sword_offer._11_binarySearch;

public class _68_searchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        int target = 6;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    // 解法: 二分查找
    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2; // 找到中点
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        // 最后还未满足，则说明需要插入，此时应该是left
        return left;
    }
}
