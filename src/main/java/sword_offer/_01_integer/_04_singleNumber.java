package src.main.java.sword_offer._01_integer;

import java.util.HashMap;
import java.util.Map;

/*
    给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
    请你找出并返回那个只出现了一次的元素。
    方法：
        将每个整数的二进制位相加 然后%3，就可以得出只出现一次的数
        难点：
            10进制如何转为二进制相加，并返回一个记录位数的array？
            如何将记录二进制的array，转为10进制数？
 */
public class _04_singleNumber {
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,100};
        int result = singleNumber_0(arr);
        System.out.println("第一次，次数不为3的数 = "+result);
        result = singleNumber_1(arr);
        System.out.println("优化 = "+result);
    }

    private static int singleNumber_0(int[] arr) {
        int result = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int value : arr) {
            if (!hm.containsKey(value)) {
                hm.put(value, 1);
            } else hm.put(value, hm.get(value) + 1);
        }
        // 遍历hashMap ，寻找value=1的解
       for(Map.Entry<Integer, Integer> kv: hm.entrySet()){
            if(kv.getValue()==1){
                result = kv.getKey();
                break;
            }
       }
        return result;
    }
    /*
        整型int是32位的
        由于其余的数都出现了三次，所有可以将所有的二进制对应的位加起来
        如果出现了3次，则该位求得的和余3都为0------->只出现一次的数，该位为0;
        如果不为0，余1，则没有该为对应的为---------->1
        不会出现余2的情况，因为重复的数，都出现了3次
     */
    private static int singleNumber_1(int[] arr) {
        int[] bits = new int[32];
        for(int num: arr) {
            for (int i = 0; i < bits.length; i++) {
                bits[i] += (num>>(31-i)) & 1;   // 目的是取到第i为的二进制，右移32-i位，并和1相与
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result<<1)+bits[i]%3;     // 一位一位获取，将上次的结果左移一位，即可添加新的位
        }
        return result;
    }
}
