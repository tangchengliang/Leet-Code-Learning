package src.main.java.sword_offer._03_String;

/*
    给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class _18_isPalindrome {
    public static void main(String[] args) {
        String s ="A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else {
                char char1 = Character.toLowerCase(s.charAt(left++));
                char char2 = Character.toLowerCase(s.charAt(right--));
                if(char1!=char2){
                    return false;
                }
            }
        }
        return true;
    }
}
/*
    双指针： 从两头往中间遍历
    Character 判断是否是字母或数字的方法
    Character.isLetterOrDigit(ch)
    使用if else if else来寻找遍历判断两个具有约束（字母或数字）的元素
 */
