package src.main.java.leet_code;

public class test_0001_两数之和 {
    public static void main(String[] args) {
        int arr[] = {7, 2, 3, 5};
        int target = 9;
        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println("i="+i+" j="+j);
                }
            }
        }
    }
}
