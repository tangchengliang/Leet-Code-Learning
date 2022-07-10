package src.main.java.sword_offer._06_stack;

import java.util.Arrays;
import java.util.Stack;

/*
    给定一个整数数组 asteroids，表示在同一行的小行星。
    对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
    每一颗小行星以相同的速度移动。找出碰撞后剩下的所有小行星。
    碰撞规则：
        两个行星相互碰撞，较小的行星会爆炸。
        如果两颗行星大小相同，则两颗行星都会爆炸。
        两颗移动方向相同的行星，永远不会发生碰撞。

    解决：使用stack实现，比较栈顶，可能存在的情况

 */
public class _37_asteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {8,-8};
        int[] result = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (true) {
                if(stack.isEmpty()){
                    // 如果栈为空了，直接将当前元素入栈
                    stack.push(asteroids[i]);
                    break;
                }
                // 找到峰顶元素，用于比较
                int peek = stack.peek();
                if (peek < 0 || (peek > 0 && asteroids[i] > 0)) {
                    stack.push(asteroids[i]);
                    break;
                } else if(peek==-asteroids[i]) {
                    // 处理相同的情况,就是弹出栈顶元素
                    stack.pop();
                    break;
                }else {
                        // peek>0 ,asteroids[i]<0
                        // 会发生碰撞 5, -6
                        int num = stack.pop();
                        int boom = num + asteroids[i];
                        if (boom > 0) {
                            stack.push(num);
                            break;
                        }
                        // 反之，则while循环，继续弹出元素比较
                    }
                }
            }
        // 最终返回一个数组
        return stack.stream().mapToInt(i->i).toArray();
    }
}
