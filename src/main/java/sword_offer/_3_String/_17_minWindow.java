package src.main.java.sword_offer._3_String;

import java.util.HashMap;
import java.util.Map;
/*
    题目：给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
    两种种解法：
        （1）使用两个map，来记录需求（t中元素）和实际（滑动窗口中的元素），来比较并移动双指针
        （2）使用一个map
            count为元素种类数，当某个元素在map中减为0时，说明t中的这个元素已经全部在窗口中，此时count--
            count==0时，记录最小窗口和窗口的起始索引，并移动左指针
            注意count是元素种类的计数，所以：移动左指针时，如果这个元素在map中为1就count++，表示种类加1

*/
public class _17_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECAODEBANC";
        String t = "ABC";
        String len = minWindow2(s, t);
        System.out.println(len);
    }

    private static String minWindow(String s, String t) {
        int minW = Integer.MAX_VALUE;
        int sL = s.length();
        int tL = t.length();

        Map<Character, Integer> need = new HashMap<>();   //记录t中的元素
        Map<Character, Integer> window = new HashMap<>();   // 记录窗口中的元素
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;     // 记录窗口中包含t中元素的个数
        int start = 0;

        while (right < sL) {
            char c = s.charAt(right);
            if (window.getOrDefault(c, 0) < need.getOrDefault(c, 0)) {
                count++;
            }
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            while (count == tL) {
                if (right - left < minW) {
                    minW = right - left;
                    start = left;
                }
                char x = s.charAt(left);
                if (need.get(x) != null && window.get(x) <= need.get(x)) {
                    count--;
                }
                window.put(x, window.getOrDefault(x, 0) - 1);
                left++;
            }
        }
        return minW == Integer.MAX_VALUE ? "" : s.substring(start, start + minW);
    }

    private static String minWindow2(String s, String t) {
        int sL = s.length();

        int start=0, end=0;
        int minStart=0, minEnd=0;
        int minWindow = Integer.MAX_VALUE;
        // 先将 t 中的 ch记录在一个map中
        // key=ch, value=出现次数
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        // 记录需要寻找的元素种类长度
        int count = map.size();

        // 开始遍历
        while (end<sL || (count==0 && end==sL)){
            // 首先判断 count是否为0了，即所有的字母种类都包含在窗口中
            if(count>0){
                char endChar = s.charAt(end);
                if(map.containsKey(endChar)){
                    map.put(endChar, map.get(endChar)-1);
                    if(map.get(endChar)==0){
                        // 此时，t中某一个字母全部在窗口中
                        count--;
                    }
                }
                end++;
            }else {
                // count=0时，即所有的字母种类都包含在窗口中
                // 先比较窗口是否最小, 并更新minStart， minEnd的值
                if(end-start<minWindow){
                    minWindow = end-start;
                    minStart = start;
                    minEnd = end;
                }
                // 接着移动左指针
                char startChar = s.charAt(start);
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar)+1);
                    if(map.get(startChar)==1){
                        // count 只记录元素的种类，所以==1时，就表示记录这位元素
                        count++;
                    }
                }
                // 移动左指针
                start++;
            }
        }
        return minWindow==Integer.MAX_VALUE?"":s.substring(minStart, minEnd);
    }
}
