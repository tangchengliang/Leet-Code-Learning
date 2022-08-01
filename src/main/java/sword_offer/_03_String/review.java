package src.main.java.sword_offer._03_String;

import java.util.HashMap;
import java.util.Map;

public class review {
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = lengthOfLongestSubstringTest(s);
        System.out.println(result);
    }

    private static String minWindowTest(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        if(sL<tL){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tL; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        int count = map.size();
        int start=0,end = 0,minStart=0,minEnd=0;
        int minWindow = Integer.MAX_VALUE;
        while (end<sL || (count==0 && end==sL)){
            if(count>0){
                // count>0,表示窗口中t的数字没列举完，须有移动右指针
                char endChar = s.charAt(end);
                if(map.containsKey(endChar)) {
                    map.put(endChar, map.get(endChar) - 1);
                    if(map.get(endChar)==0){
                        // 如果当前个数为0，表明是要添加的元素
                        count--;
                    }
                }
                end++;
            }else {
                // count = 0, 表示找到了t中的所有字母，此时计算窗口大小，并记录窗口起始和终止位置
                if(end-start<minWindow){
                    minWindow = end-start;
                    minEnd = end;
                    minStart = start;
                }

                // 记录后需要移动左指针继续寻找最短长度
                char startStr = s.charAt(start);
                if(map.containsKey(startStr)) {
                    map.put(startStr, map.get(startStr) + 1);
                    if (map.get(startStr) == 1) {
                        count++;
                    }
                }
                start++;
            }
        }
        return minWindow==Integer.MAX_VALUE?"":s.substring(minStart, minEnd);
    }

    public static int lengthOfLongestSubstringTest(String s){
        int sL = s.length();
        int left=-1, right=0;
        int maxL=1;
        int[] arr = new int[256];
        for (; right < sL; right++) {
            arr[s.charAt(right)]++;
            while (moreThanOne(arr)){
                ++left;
                arr[s.charAt(left)]--;
            }
            maxL = Math.max(right-left, maxL);
        }
        return maxL;
    }

    private static boolean moreThanOne(int[] arr) {
        for(int num:arr){
            if(num>1){
                return true;
            }
        }
        return false;
    }
}
