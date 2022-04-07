package src.main.java.lanqiao;

public class test_05_li_bai_wine {
    static int count=0;
    public static void main(String[] args) {
        f(5,9,2);
        System.out.println(count);
    }

    private static void f(int a, int b, int sum) {
        if(a==0 && b==0 && sum==1){
            count++;
        }
        if(a>0){
            f(a-1,b,sum*2);
        }
        if(b>0){
            f(a,b-1,sum-1);
        }
    }
}
