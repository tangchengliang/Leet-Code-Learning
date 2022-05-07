package src.main.java.leet_code.easy;

import java.util.Deque;
import java.util.LinkedList;

public class test_0020_有效的括号 {
    public static void main(String[] args) {
        String s = "({}[])";
        boolean res = isValid(s);
        System.out.println(res);
    }
    public static boolean isValid(String s){
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            // 遇到左括号，就把相应的右括号入栈
            if(ch=='('){
                deque.push(')');
            }else if(ch=='{'){
                deque.push('}');
            }else if (ch=='['){
                deque.push(']');
            }else if (deque.isEmpty() || deque.peek() != ch){  // 如果为空，或者栈顶不匹配，则返回false
                return false;
            }else {
                // 如果是右括号，判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        // 最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
/*
 *  分析不匹配的情况:
 *      第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
        第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
        第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false

     总结：
     * 类似于对称匹配的问题，可考虑  *栈*
     * 推荐用deque --->实现栈
     * deque : 双向队列
     * addFirst()  removeFirst()  getFirst()
     * addLast()   removeLast()   getLast()
     *
 */
