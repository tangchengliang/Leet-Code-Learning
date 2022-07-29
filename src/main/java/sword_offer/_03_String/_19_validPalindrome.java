package src.main.java.sword_offer._03_String;

public class _19_validPalindrome {
    public static void main(String[] args) {
        String s = "abba";
        boolean result = validPalindrome(s);
        System.out.println(result);
    }

    private static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 找到不匹配的两个点，需要删除其中一个
        for (; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
        }
        int a=1;
        // 找到left和right，删除其中一个是否是回文
        // 如果 本身是奇回文，left==s.length()/2, 例如 abcba--->2=5/2=2
        // 如果是 偶回文 left==s.length()/2, 例如 abccba----> 3=6/2=3
        // 注意： for循环结束条件，left++，right--，注意left, right要作为 全局变量
        return left == s.length() / 2 || isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
    }

    private static boolean isPalindrome(String s, int start, int end) {
        // 从start到end判断是否是回文
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                break;
            }
            start++;
            end--;
        }
        return start>=end;
    }
}
/*
    题目是：删除一个字符后，判断是否是回文(两端往中间移动)
        利用双指针，同时移动，遇到不等的两个值---->即找到了待删除的字符（两者选其一）
        分别忽略掉其中一个字符，判断剩余s是否是回文（left+1, right）（left, right-1）
 */
