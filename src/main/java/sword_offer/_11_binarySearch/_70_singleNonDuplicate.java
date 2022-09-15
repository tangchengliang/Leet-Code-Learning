package src.main.java.sword_offer._11_binarySearch;

public class _70_singleNonDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4};
        int result = singleNonDuplicate(nums);
        System.out.println(result);
    }

    // 分成两个元素一组，使用二分法查找
    // {1,1,2,2,3,4,4}---->(1,1),(2,2),(3,4),4
    // {1,1,2,2,4,4,3}---->(1,1),(2,2),(4,4),3
    private static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length/2;
        while (left<=right){
            int mid = (left+right)/2;
            int i = mid*2;
            if(i<nums.length-1 && nums[i]!=nums[i+1]){
                if(mid==0 || nums[i-2]==nums[i-1]){
                    return nums[i];
                }
                // 在左边
                right = mid-1;
            }else {
                // 在右边
                left = mid+1;
            }
        }
        // 如果最后还没有结果，说明是最后一个数
        return nums[nums.length-1];
    }
}
