package src.main.java.sword_offer._02_array;

public class _12_NumMatrix {
    static int[][] sums;
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        sumMatrix(matrix);
        System.out.println(sumRegion(2,1,4,3));
    }

    public static void sumMatrix(int [][] matrix){
        if(matrix.length==0 || matrix[0].length==0){
            return;
        }
        sums = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            int rowSum=0;
            for(int j=0;j<matrix[0].length;j++){
                rowSum+=matrix[i][j];
                sums[i+1][j+1]+=sums[i][j+1]+rowSum;
            }
        }
    }
    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]+sums[row1][col1];
    }
}
/*
    求矩形框的和，可以化为大的矩形-小的矩形
    关键点：注意求辅助和矩阵时，对应的点，大小要比原有矩阵多一行
 */
