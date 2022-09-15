package src.main.java.sword_offer._03_String;

public class _14_checkInclusion {
    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "eidbacaooo";
        boolean result = checkInclusion1(s1, s2);
        System.out.println(result);
    }

    private static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        // 建立一个26位的数组，来存放出现过得元素
        int[] cnt1 = new int[26];
        // 将s1存放到cnt1中
        for (char c : s1.toCharArray()) {
            cnt1[c - 'a']++;
        }
        // 定义双指针，利用另外一个辅助数组
        // cnt2: 记录s2滑动窗口中元素出现的次数，出现则+1，
        // 如果该元素没有在s1中出现或出现次数大于s1（对应的索引值比较），则需要移动左指针，变化滑动窗口
        // 如果该元素出现在s1中，则判断当前的长度是否符合要求，不符合要求，right++
        int left = 0;
        int[] cnt2 = new int[26];
        for (int right = 0; right < len2; right++) {
            int index = s2.charAt(right) - 'a';
            cnt2[index]++;
            while (cnt2[index] > cnt1[index]) {
                cnt2[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len1) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkInclusion1(String s1, String s2) {
        // 使用双指针定位窗口大小，同时滑动，+hash表来完成
        if(s1.length()>s2.length()){
            return false;
        }
        int window = s1.length();
        // 使用数组模拟26位的小写字母
        int[] hash1 = new int[26];
        // 在hash1中填充字符, 同时填充window的s2的字符
        for (int i = 0; i < s1.length(); i++) {
            hash1[s1.charAt(i)-'a']++;
            hash1[s2.charAt(i)-'a']--;
        }
        if(allZero(hash1)){
            return true;
        }
        //在s2中，从window开始，寻找变位词
        for(int i=window;i<s2.length();i++){
            // 窗口移动，左边的值+1还原，右边的值-1做比较
            hash1[s2.charAt(i)-'a']--;
            hash1[s2.charAt(i-window)-'a']++;
            if(allZero(hash1)){
                return true;
            }
        }
        return false;
    }
    public static boolean allZero(int[] arr){
        for(int num:arr){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
/*
    变位数：s2的连续子集，存在与s1相同，只是顺序不同的集合，就称s2存在s1的变位数
 */
