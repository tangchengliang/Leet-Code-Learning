package src.main.java.lanqiao;

public class test_05_hex_fill_num {
    public static void main(String[] args) {
        int arr[] = {2,4,5,6,7,9,10,11,12};
        f(arr,0);
    }
    public static void f(int[] arr, int k){
        if(k==arr.length){
            int t0=8+arr[0]+arr[1]+arr[2];
            int t1=8+arr[8]+arr[6]+3;
            int t2 = 1+arr[0]+arr[8]+arr[7];
            int t3 = 1+arr[1]+arr[3]+arr[4];
            int t4 = arr[7]+arr[6]+arr[5]+arr[4];
            int t5 = arr[2]+arr[3]+arr[5]+3;
            if(t0==t1 && t1==t2 && t2==t3 && t3==t4 && t5==t4){
                System.out.println(arr[8]);
                return;
            }
        }
        for(int i=k;i<arr.length;i++){
            int temp = arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
            f(arr,k+1);
            temp = arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
        }
    }
}
