package src.main.java.sword_offer._3_String;

public class _20_countSubstring {
    public static void main(String[] args) {
        String s = "aaa";
        int count = countSubstring(s);
        System.out.println(count);
    }

    private static int countSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int start = 0;
        int count = 0;
        for(;start<s.length();start++){
            // 以某个元素为中心，左右移动指针寻找回文---->奇回文
            count += isPalindrome(s,start,start);
            // 以两个元素为中心，左右移动指针寻找回文---->偶回文
            count += isPalindrome(s,start,start+1);
        }
        return count;
    }

    private static int isPalindrome(String s, int start, int end) {
        int count = 0;
        // 从中间往两边分开，寻找回文
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            count++;
            start--;
            end++;
        }
        return count;
    }
}
/*
    寻找回文计数：
        两个指针从中间开始向两端移动，注意奇偶回文的处理方法
 */
