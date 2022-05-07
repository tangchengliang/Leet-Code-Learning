package src.main.java.data_structure._03_stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        String k = "";
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        while (loop){
            System.out.println("------跑一把-----");
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            k = sc.nextLine();
            switch (k){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个整数:");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int val = stack.pop();
                        System.out.println("pop的数="+val);
                        break;
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case "exit":
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

// 定义一个ArrayStack 表示栈
class ArrayStack{
    private int maxSize; //大小
    private int[] stack; //数组，表示栈
    private int top = -1; //栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.print(stack[i]+ " ");
        }
        System.out.println();
    }
}