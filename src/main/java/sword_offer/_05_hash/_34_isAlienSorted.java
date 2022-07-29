package src.main.java.sword_offer._05_hash;

/*
    判断列表中的元素是否按，规定的排序，返回True or False
 */
public class _34_isAlienSorted {
    public static void main(String[] args) {
        String[] str = {"offer", "is", "coming"};
        String order = "hlabdefgjkmnopqrsituvwxycz";
        boolean result = isAlienSorted(str, order);
        System.out.println(result);
    }

    private static boolean isAlienSorted(String[] str, String order) {
        // 先将oder 用数组hash表存储: key 是字母, value是位置
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i)-'a'] = i;
        }

        // 依次遍历str数组，比较字母元素
        for (int i = 0; i < str.length-1; i++) {
            if(!isSorted(str[i], str[i+1], orderArray)){
                return false;
            }
        }
        return true;
    }

    private static boolean isSorted(String s1, String s2, int[] orderArray) {
        int i=0;
        for(;i<s1.length() && i<s2.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(orderArray[ch1-'a']>orderArray[ch2-'a']){
                // 大于，直接返回false
                return false;
            }
            if(orderArray[ch1-'a']<orderArray[ch2-'a']){
                // 小于，返回true
                return true;
            }
            // 等于，就继续遍历
        }
        // 最后，判断长度是否是i
        // 如果最后的长度为i，说明s1先遍历完，则s1在前面，返回True；
        // 反之s2比s1长，该放到后面， 返回True
        return s1.length()==i;
    }
}

/*
    总结：对于无序不重复的字符串，要保存为hash，并记录顺序
        key = 字母
        value = 出现位置
        arr[str.char[i]='a'] = i;
    比较两字符串按字母出现的位置，有三种情况
        依次取字母作比较：在两个长度范围内
        小于--->
        大于--->
        等于--->
        遍历完其中一个长度之后，如果还没结束，就判断哪一个先遍历完 return i==s1.length()
 */
