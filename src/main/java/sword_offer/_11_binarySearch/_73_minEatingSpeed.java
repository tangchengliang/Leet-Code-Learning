package src.main.java.sword_offer._11_binarySearch;

public class _73_minEatingSpeed {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int H = 8;
        int minEat = minEatingSpeed(arr, H);
        System.out.println(minEat);
    }

    // 狒狒吃香蕉
    /*
        使用二分法求解
           1.最小1，最大为数组中的最大值
           2.中间 mid 与 needHour的关系
           3.确定左右区间，如何选择
     */
    private static int minEatingSpeed(int[] arr, int h) {
        // 找到最大值
        int max = Integer.MIN_VALUE;
        for(int num:arr){
            max = Math.max(num, max);
        }

        // 确定第一个区间
        int left = 1;
        int right = max;
        while (left<=right){
            int mid = (left+right)/2;
            int needHours = getHours(arr, mid);
            if(needHours<=h){
                // 需要的时间小于规定值，判断左边是否大于规定值，
                // 因为越到右边，猴子吃的越快
                if(mid ==1 || getHours(arr, mid-1)>h){
                    return mid;
                }
                right = mid-1;
            }else {
                left = mid+1;
            }

        }
        return -1;
    }

    private static int getHours(int[] arr, int speed) {

        // 通过speed，判断需要多少个小时
        int hours = 0;
        for(int num: arr){
            hours += 1+(num-1)/speed;
        }
        return hours;
    }
}
