package src.main.java.sword_offer._03_String;

import java.util.HashMap;
import java.util.Map;

public class _17_minWindow {
    public static void main(String[] args) {
        String s = "ADOBECAODEBANC";
        String t = "ABC";
        String len = minWindow(s, t);
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
}
