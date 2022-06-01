package src.main.java.sword_offer._3_String;

import java.util.HashMap;
import java.util.Map;

public class _16_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring2(String s){
        if(s.length()==0){
            return 0;
        }
        int maxL=0;
        // 使用map来记录元素是否出现，key=char, value=i 索引
        Map<Character, Integer> map = new HashMap<>();
        int left=0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                // 如果，遇到重复的，就将left指向重复的右边一位
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, right);
            maxL=Math.max(maxL, right-left+1);
        }
        return maxL;
    }
    private static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int maxL=0;
        int countDup = 0;
        // 注意题目 不是小写字母，可能是所以的字符串，所以，数组长度定义为256
        int[] cnt = new int[256];
        int left=-1;
        for(int right=0;right<s.length();right++){
            int index = s.charAt(right);
            cnt[index]++;
            if(cnt[index]==2){
                countDup++;
            }

                while (countDup>0){
                    left++;
                    cnt[s.charAt(left)]--;
                    if(cnt[s.charAt(left)]==1){
                        countDup--;
                }
            }
            // 注意 这里不能right-left+1, 因为有一个重复的，所以不能+1
            maxL = Math.max(maxL, right-left);
        }
        return maxL;
    }
}
