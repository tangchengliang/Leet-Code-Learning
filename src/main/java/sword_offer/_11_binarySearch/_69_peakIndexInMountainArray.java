package src.main.java.sword_offer._11_binarySearch;

public class _69_peakIndexInMountainArray {
    public static void main(String[] args) {
        int[] nums = {3,5,3,2,0};
        int result = peakIndexInMountainArray(nums);
        System.out.println(result);
    }

    private static int peakIndexInMountainArray(int[] nums) {
        // 注意：山峰一定在中间，故可以从第一个和倒数第二个元素开始，避免了越界的问题
        int left = 1;
        int right = nums.length-2;
        while (left<=right){
            int mid = (left+right)/2;
            // 因为山峰一定在数组中间，可以不用考虑边界条件
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid-1]<nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}

/*
    注意从 1----n-2查找，防止越界
 */
