package src.main.java.sword_offer._3_String;

public class _14_checkInclusion {
    public static void main(String[] args) {
        String s1 = "baa";
        String s2 = "ccbcabacc";
        boolean result = checkInclusion(s1, s2);
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
}
/*
    变位数：s2的连续子集，存在与s1相同，只是顺序不同的集合，就称s2存在s1的变位数
 */
