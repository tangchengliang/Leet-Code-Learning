package src.main.java.data_structure.sparse_array;

public class test_01_SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组11 * 11
        // 0: 表示没有棋子， 1表示黑子,2表蓝子
        int[][] array = new int[11][11];
        array[1][1] = 1;
        array[3][1] = 2;
        array[2][10] = 1;

        // 打印这个数组
        System.out.println("原始数组:");
        for (int[] row : array) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
        /*
         * 将二维数组转稀疏数组的思想
         *  1. 先遍历二维数组得到非0数据的个数
         *  2. 创建对应的稀疏数组, 并赋值
         *  3. 将二维数据存入稀疏数组
         */
        int sum = 0;
        for (int[] row : array) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;

        int row = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = array[i][j];
                    row++;
                    if (row>sum){
                        break;
                    }
                }
            }
        }
        // 打印稀疏数组
        System.out.println("稀疏数组");
        for (int[] ints : sparseArray) {
            for (int j = 0; j < sparseArray[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        // 还原数组
        System.out.println("原数组");
        int[][] old_array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            old_array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] old_row : old_array) {
            for (int old_data : old_row) {
                System.out.print(old_data + " ");
            }
            System.out.println();
        }
    }
}
