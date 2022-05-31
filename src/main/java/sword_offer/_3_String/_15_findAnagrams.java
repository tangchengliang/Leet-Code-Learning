package src.main.java.sword_offer._3_String;

import java.util.LinkedList;
import java.util.List;

public class _15_findAnagrams {
    public static void main(String[] args) {
        String s1 = "ba";
        String s2 = "ccabcababcc";
        List<Integer> result = new LinkedList<>();
        result = findAnagrams(s1, s2);
        System.out.println(result);
    }

    private static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> result = new LinkedList<>();
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2){
            return result;
        }
        int[] cnt1= new int[26];
        int[] cnt2 = new int[26];
        for(char c: s1.toCharArray()){
            cnt1[c-'a']++;
        }
        int left = 0;
        for(int right=0;right<s2.length();right++){
            int index = s2.charAt(right)-'a';
            cnt2[index]++;
            while (cnt2[index]>cnt1[index]){
                cnt2[s2.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1==len1){
                result.add(left);
                cnt2[s2.charAt(left)-'a']--;
                left++;
            }
        }
        return result;
    }
}
