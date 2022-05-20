package src.main.java.sword_offer._01_integer;

public class _02_addBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        String result = addBinary(a, b);
        System.out.println(a + "+" + b + "=" + result);
    }

    private static String addBinary(String a, String b) {
        // 定义一个可变长度的字符串容器
        StringBuilder sb = new StringBuilder();
        // 从右往左，所以从最大索引开始取一位
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 初始进位设置0
        int carry = 0;
        // 遍历元素
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0; // 每次最多进一位
            sum = sum >= 2 ? sum - 2 : sum;
            sb.append(sum);
        }
        // 遍历完后，判断是否还有进位
        if(carry == 1){
            sb.append(1);
        }
        // 因为sb从左到右存数据，所以需要反转结果
        return sb.reverse().toString();
    }
}

/*
    总结：（1）二进制，逢二进一，用carry表示进位
         （2）从右往左开始，a.length()-1
         （3）字符——'0', 可以转为整数
         （4）StringBuilder: 可以存放所有类型的数据，最终输出，可以toString(),转为统一类型
    扩展：
        String: 不可变字符串
        StringBuffer: 可变字符串，线程安全  ------>推荐多线程使用
        StringBuilder: 可变字符串，速度快，线程不安全-------->推荐单线程

 */
