package src.main.java.sword_offer._05_hash;

import java.util.HashMap;

/*
    easy
    判断两字符串是否是变位词：字母相同，顺序不一样
 */
public class _32_isAnagram {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cab";
        boolean result1 = isAnagram1(s1, s2);
        System.out.println("解法一，只有字母 = "+result1);

        boolean result2 = isAnagram2(s1, s2);
        System.out.println("解法一，所有字符 = "+result2);
    }

    // 解法二：数组长度不够用，用HashMap
    private static boolean isAnagram2(String s1, String s2) {
        if(s1.equals(s2)){
            return false;
        }
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch:s1.toCharArray()){
            count.put(ch, count.getOrDefault(ch, 0)+1);
        }
        for(char ch: s2.toCharArray()){
            if(count.get(ch)==0 || !count.containsKey(ch)){
                return false;
            }
            count.put(ch, count.get(ch)-1);
        }
        return true;
    }

    // 解法一：只有26个字母，用数组模拟哈希表
    private static boolean isAnagram1(String s1, String s2) {
        if(s1.equals(s2)){
            return false;
        }
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] count = new int[26];
        for (char ch:s1.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch: s2.toCharArray()){
            if(count[ch-'a']==0){
                return false;
            }
            count[ch-'a']--;
        }
        return true;
    }



}
