package src.main.java.data_structure._03_stack;

public class Calculator {
    public static void main(String[] args) {
        String express = "7-2-2+4*2-3";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        char ch; //将每次扫描得到char 保存到ch
        int num1;  //pop第一个数
        int num2;  //pop第二个数
        int oper;  //操作符
        int res;   //保留结果
        String keepNum = ""; //用于拼接多位数
        boolean loop = true;
        while (loop) {
            ch = express.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                //如果是操作符，判断当前的操作符栈是否为空
                if (operStack.isEmpty()) {
                    // 为空，直接入栈
                } else {
                    // 先比较与上一个操作符的优先级
                    if (operStack.priority(operStack.getPeek()) >= operStack.priority(ch)) {
                        // 栈顶优先级大，则需要计算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.calculate(num1, num2, oper);
                        numStack.push(res);
                    }
                    // 栈顶优先级小, 直接入栈
                }
                operStack.push(ch);
            } else {
                //如果是数字，直接入栈
                // 考虑多位数，，需要向expression 的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                keepNum += ch;
                if (index == express.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(express.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是操作符
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= express.length()) {
                loop = false;
            }
        }
        // 遍历完成后，顺序从栈中取出数据并运行
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.calculate(num1, num2, oper);
            numStack.push(res);
        }
        res = numStack.pop();
        System.out.println(express + "=" + res);
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法添加数据");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无pop数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[top] + " ");
        }
        System.out.println();
    }

    /*
        计算器，需要添加一些方法，
     */
    // 获取栈顶的值
    public int getPeek() {
        if (top == -1) {
            throw new RuntimeException("栈空，没有数据，请添加数据");
        }
        return stack[top];
    }

    // 判断是否是操作数
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 判断操作符，优先级
    public int priority(int oper) {
        if (oper == '+' || oper == '-') {
            return 1;
        } else if (oper == '*' || oper == '/') {
            return 2;
        } else {
            return -1;
        }
    }

    // 计算方法
    public int calculate(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
/*
 * 总结：（1）char - int = 48
 *       (2) 参数为int型可以传入char,将其转为了Ascii
 *
 */


