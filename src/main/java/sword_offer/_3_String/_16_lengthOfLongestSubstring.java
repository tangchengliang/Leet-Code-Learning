package src.main.java.sword_offer._3_String;

public class _16_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
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
