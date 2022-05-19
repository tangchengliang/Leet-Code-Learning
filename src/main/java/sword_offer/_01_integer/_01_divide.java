package src.main.java.sword_offer._01_integer;

public class _01_divide {
    public static void main(String[] args) {
        int x = 16;
        int y = 3;
        int result = divide(x, y);
        System.out.println(result);
    }

    // x/y
    public static int divide(int x, int y) {
        // 最小的int整数，-2^31=0x80000000, 一半-2^30=0xc0000000
        if (x == 0x80000000 && y == -1) {
            return Integer.MAX_VALUE;
        }
        // 将输入的数都变为负数，同时用一个negative来判断最终结果的符号
        int negative = 2;
        if (x > 0) {
            negative--;
            x = -x;
        }
        if (y > 0) {
            negative--;
            y = -y;
        }
        int result = divideCore(x, y);
        return negative == 1 ? -result : result;
    }

    public static int divideCore(int x, int y) {
        int result = 0;
        while (x <= y) {  // 注意，这里x，y都为负数
            int value = y;       // 选取被除数y作为value
            int multiple = 1;    // 倍数
            // 循环比较，找出合适的倍数
            while (value >= 0xc0000000 && x <= value + value) {
                multiple += multiple;  // 这里是加自己，成倍的增加
                value += value;        // value 加自己，也是成倍的增加
            }
            // 循环完成，变换被除数的值，同时改变result的值
            result += multiple;
            x -= value;
        }

        return result;
    }
}

/*
 * 总结：利用倍数做 +-
 * 把所有的整数都转为负数求解，因为最小的负数（-2^31）转为整数（2^31-1）会溢出
 * 注意：(-2^31)/(-1) = 2^31 也会溢出
 */


