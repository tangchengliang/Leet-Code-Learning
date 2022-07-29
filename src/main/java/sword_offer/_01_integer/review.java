package src.main.java.sword_offer._01_integer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    总结：（1）计算二进制中1的个数 i&(i-1), 根据 i&(i-1)计算i中1的个数, 根据i/2计算i中1的个数
          (2)记录字符串中出现的字符
                *用数组模拟哈希表
                **用整数的二进制数位
          (3)取得二进制数的最后一位 i&1
          (4)两数* /,判断正负
          (5)'1'变int，'1'-'0'
          (6)*****
               难：10进制 如何转为 二进制位，并返回一个记录0, 1的array？依次左移（32-i）取出最后一位，取32次
               如何将记录二进制的array，转为10进制数？

 */
public class review {
    public static void main(String[] args) {
        String[] arr = {"abcw","baz","foo","bar","fxyz","abcdef"};
        System.out.println(maxProductTest2(arr));
    }

    public static int maxProductTest2(String[] arr){
        int[] binary = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            for(char c:arr[i].toCharArray()){
                // 异或
                binary[i] |= 1<<(c-'a');
            }
        }

        // 遍历
        int maxProduct = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if((binary[i] & binary[j]) == 0){
                    maxProduct = Math.max(maxProduct, arr[i].length()*arr[j].length());
                }
            }
        }
        return maxProduct;
    }

    public static int maxProductTest(String[] arr){
        // 要判断一个字符中，是否包含另外的字符中含有的字母
        // 使用数组模拟hash表，存放元素
        boolean[][] stringToBool = new boolean[arr.length][26];
        for (int i = 0;i<arr.length;i++){
            for(char ch: arr[i].toCharArray()){
                stringToBool[i][ch-'a'] = true;
            }
        }

        // 依次比较每个元素
        boolean flag = true;
        int maxProduct = 0;
        for (int i = 0; i < stringToBool.length; i++) {
            for (int j = i+1; j < stringToBool.length; j++) {
                for (int k = 0; k < 26; k++) {
                    if(stringToBool[i][k] & stringToBool[j][k]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    int Product = arr[i].length() * arr[j].length();
                    maxProduct = Math.max(maxProduct, Product);
                }
                flag = true;
            }
        }
        return maxProduct;

    }

    public static int singleNumber2(int[] arr){
        int result = 0;
        // 整数 32位，重复的都出现了3次，因此可以每一位累加然后对3求余数
        int[] numSum = new int[32];
        // 难点：十进制数如何转为2进制数相加
        // 解决：使用位于运算从左往右取
        for(int num:arr){
            for (int i = 0; i < 32; i++) {
                numSum[i]+=(num>>(31-i))&1;  // 最后和1求&，即得到最后一位
            }
        }
        // numSum再按位求余
        // 难点，如何将表示二进制的数组转换为十进制
        // 解决：依次取出一位（这里需要先对3求%），然后左移+现在的一位
        for (int i = 0; i < 32; i++) {
            result = (result<<1)+numSum[i]%3;
        }
        return result;
    }

    public static int singleNumber(int[] arr){
        // HashMap求解
        Map<Integer,Integer> numToCount= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 记录数出现的次数
            numToCount.put(arr[i],numToCount.getOrDefault(arr[i], 0)+1);
        }
        // 遍历map
        Set<Integer> keySet = numToCount.keySet();
        for(Integer key:keySet){
            if(numToCount.get(key)==1){
                return key;
            }
        }
        return -1;
    }

    public static int[] countBitsTest3(int n){
        int arr[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = arr[i>>1]+(i&1);
        }
        return arr;
    }

    public static int[] countBitsTest2(int n){
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <=n; i++) {
            arr[i] = arr[i&(i-1)]+1;
        }
        return arr;
    }
    public static int[] countBitsTest(int n){
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j!=0){
                arr[i]++;
                j = j &(j-1);
            }
        }
        return arr;
    }

    public static String addBinaryTest(String x, String y){
        StringBuilder result = new StringBuilder();
        int lx = x.length()-1;
        int ly = y.length()-1;
        int carry = 0;
        while (lx>=0 || ly>=0){
            int x1 = lx>=0?x.charAt(lx--)-'0':0;
            int y1 = ly>=0?y.charAt(ly--)-'0':0;
            int sum = x1+y1+carry;
            carry = sum>=2?1:0;
            sum = sum>=2?sum-2:sum;
            result.append(sum);
        }
        if (carry>=1){
            result.append(carry);
        }
        return new String(result.reverse());
    }

    // 第一种方式是依次减去被除数，然后count+1,----->效率低下，而且还要考虑正负数
    /**
     * 转为负数求解，但是最大正数为2^31-1，最小负数为-2^31，考虑边界情况
     * 如果除法结果溢出，则返回 2^31 − 1
     * @param x
     * @param y
     * @return
     */
    private static int divide1(int x, int y) {
        // 处理溢出情况
        if(x==Integer.MIN_VALUE && y==-1){
            return Integer.MAX_VALUE;
        }
        // 将x和y变为负数,且记录结果的正负数
        int negative = 0;
        if(x>0){
            x = -x;
            negative++;
        }
        if (y>0){
            y = -y;
            negative++;
        }
        int result = divideTowNum(x,y);
        return negative==1?-result:result;

    }

    private static int divideTowNum(int x, int y) {
        // 每次减去最大被初数的二倍
        int result = 0;
        while (x<=y){
            int multi = 1;
            int value = y;
            // 依次寻找最大的倍数
            while (value>=Integer.MIN_VALUE/2 && x<= value+value){
                multi+=multi;
                value+=value;
            }
            result+=multi;
            x-=value;
        }
        return result;
    }
}
