package src.main.java.sword_offer._10_prefixTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _63_replaceWords {
    public static void main(String[] args) {
        List<String> dict = new LinkedList<>(Arrays.asList("cat", "bat", "rat"));
        String sentence = "the cattle was rattled by the battery";

        String result = replaceWords(dict, sentence);
        System.out.println(result);
    }

    // 1.根据字典建立前缀树
    private static TrieNode buildTrie(List<String> dict){
        TrieNode root = new TrieNode();
        for(String word: dict){
            TrieNode node = root;
            for(char ch: word.toCharArray()){
                if(node.children[ch-'a'] == null){
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    // 2.查找单词的前缀
    private static String findPrefix(TrieNode root, String word){
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for(char ch: word.toCharArray()){
            if(node.isWord || node.children[ch-'a']==null){
                break;
            }
            sb.append(ch);
            node = node.children[ch-'a'];
        }
        // 要最后一个节点的isWord才是前缀树
        return node.isWord ? sb.toString(): "";
    }

    // 3.替换单词的前缀
    // 如果在前缀树中找到单词的前缀，则返回该前缀；反之，返回一个空字符串
    public static String replaceWords(List<String> dict, String sentence){
        TrieNode root = buildTrie(dict);
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            String prefix = findPrefix(root, words[i]);
            if(!prefix.isEmpty()){
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }
}
