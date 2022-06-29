package src.main.java.sword_offer._05_hash;

import java.util.*;

/*
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class _33_groupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(str);
        System.out.println("解法一，乘法 = "+result);
        result = groupAnagrams2(str);
        System.out.println("解法二，变位词映射-->排序单词 = "+result);
    }

    // 方法一：将26个字母映射为质数，然后将相同的相乘，得到互为变为词的乘机相同
    // 可能会出现乘机溢出
    private static List<List<String>> groupAnagrams(String[] strs) {
        int[] hash = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

        Map<Long, List<String>> groups = new HashMap<>();
        for(String str: strs){
            long wordMulti = 1;
            for(char ch : str.toCharArray()){
                wordMulti*=hash[ch-'a'];
            }
            groups.putIfAbsent(wordMulti, new LinkedList<String>());
            groups.get(wordMulti).add(str);
        }
        return new LinkedList<>(groups.values());
    }

    // 方法二：将变位词----> 映射到单词排序的同一个单词中
    // 可能会出现乘机溢出
    private static List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            groups.putIfAbsent(sorted, new LinkedList<String>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}
/**
 * 总结：Map中存放 可变 List
 *      xxx.putIdAbsent(key, new LinkedList<xx>()); 如果没有这个key， 则创建这个key，value为默认值
 *      xxx.get(key).add(str);  对 key 的 value 增加值
 *
 *      HashMap的另外一种使用
 *          key： 作为唯一键，可以将题中信息转换为唯一的key
 *              例如：单词字母指向质数，通过不同单词的乘积---->确定唯一key
 *              将单词排序后的str 作为 key
 *          value 返回值，
 *              value 作为 List， 最后返回时----> return new LinkedList<>(groups.values());
 */
