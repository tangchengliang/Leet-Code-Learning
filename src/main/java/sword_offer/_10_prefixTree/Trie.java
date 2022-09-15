package src.main.java.sword_offer._10_prefixTree;

public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    // 插入元素
    public void insert(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            if(node.children[ch-'a'] == null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    // 查询单词
    public boolean search(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isWord;
    }

    // 查找字符串前缀
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char ch:prefix.toCharArray()){
            if(node.children[ch-'a'] == null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return true;
    }
}

class TrieNode{
    TrieNode children[];
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26]; // 假设只有26个小写字母
    }
}
