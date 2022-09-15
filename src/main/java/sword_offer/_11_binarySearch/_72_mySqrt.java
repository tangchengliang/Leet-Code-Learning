package src.main.java.sword_offer._11_binarySearch;


/**
 * 使用二分法求平方根
 */
public class _72_mySqrt {
    public static void main(String[] args) {
        int result = mySqrt(25);
        System.out.println(result);
    }

    /*
        二分法查找，确定查找区间，以及什么时候左移，什么时候右移
     */
    private static int mySqrt(int num) {
        // 显然最小值为1，最大值为num
        int left = 1;
        int right = num/2 +1;
        while (left<=right){
            int mid = (left+right)/2;
            // 防止 mid * mid 溢出
            if(mid<=num/mid){ // mid * mid<=num,判断小于它的值是否>num
                if(mid==1 || (mid+1)>num/(mid+1)){ // (mid+1) * (mid+1) >= num
                    return mid;
                }
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
