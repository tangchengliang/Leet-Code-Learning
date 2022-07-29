package src.main.java.sword_offer._01_integer;

/*
    给定一个字符串数组 words，
    请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
    假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。

    难点：如何快速比较两个字符串是否含有相同的元素？
        解决：1）小写字母26个，将字符串映射到二维数组中，建立hash，遍历时，指针为0-26个字母，依次取出元素相与并判断是否有相同元素

            2）用二进制数，保存String中出现过的字母，优化计算********
 */

public class _05_maxProduct {
    public static void main(String[] args) {
        String[] arr = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int result = maxProduct_0(arr);
        System.out.println("解法1 = " + result);
        result = maxProduct_1(arr);
        System.out.println("解法2 = " + result);
    }

    private static int maxProduct_0(String[] arr) {
        // 建立一个bool型的hash表，true表示对应的元素出现
        boolean[][] flag = new boolean[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            for (char c : arr[i].toCharArray()) {
                flag[i][c - 'a'] = true;
            }
        }

        int result = 0;
        // 依次遍历，比较数组中的元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int k = 0;
                // 从a到z，依次判断是否有相同的元素
                for (; k < 26; k++) {
                    // 注意 & 和 && 的区别
                    if (flag[i][k] & flag[j][k]) {
                        // 有相同元素，则退出
                        break;
                    }
                }
                // 遍历完a到z没有相同元素时，则计算长度
                // 注意，遍历完最后一位后，k++,得到k=26，果果这里不加判断，break之后，就会计算result
                if (k == 26) {
                    result = Math.max(result, arr[i].length() * arr[j].length());
                }
            }
        }
        return result;
    }

    // 2.整数的二进制数位记录数据
    private static int maxProduct_1(String[] arr) {
        int[] binary = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (char c : arr[i].toCharArray()) {
                // 这里有点秀：c-'a'可以定位要查字符对应的位置，将1往左移这个位置，在二进制中，即可得到1对应的位置
                // 在与之前的 或 ，即可得到二进制表示字符串包含的元素
                binary[i] |= 1 << (c - 'a');
            }
        }

        int result = 0;
        // 将二进制数相与，结果为0，则是两个包含不同元素的字符串
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((binary[i] & binary[j]) == 0) {
                    result = Math.max(result, arr[i].length()*arr[j].length());
                }
            }
        }
        return result;
    }
}

/*
    总结：
        当需要快速判断某个元素是否出现在一个集合中时，考虑---->哈希算法

      1.对于判断 字符 是否出现在集合中，可以考虑bool型的hash数组
        （1）bool型，元素存在可用，flag[字符-'a']=true 表示
        （2）从a到z，即for(int k=0;k<26;i++)，依次遍历
            使用flag[i][k] & flag[j][k] 是否为真，判断是否在集合中
        （3）求取最大值，考虑  Max.max(result, x)

       2.用整数的二进制数位记录字符串中出现的字符（0-false，1-true）
       难点：如何将字符串中出现的元素，转换成一维二进制数？
            两个二进制数相与，如果结果为0，则表明两个字符串中不存在相同的字符
            26个字符，int型有32位

      3. & 和 &&
            按位与: 转换成二进制，进行与运算
            逻辑与： 只要左边为false，右边就不在运算

      4. break 只跳出一层循环

 */