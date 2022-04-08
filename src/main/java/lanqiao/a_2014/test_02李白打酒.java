package src.main.java.lanqiao.a_2014;

public class test_02李白打酒 {
    static int count=0;
    public static void main(String[] args) {
        dfs(5,9,2);
        System.out.println(count);
    }

    // 递归
    private static void dfs(int a, int b, int sum) {
        if(a==0 && b==0 && sum==1){
            count++;
        }
        if(a>0){
            dfs(a-1,b,sum*2);
        }
        if(b>0){
            dfs(a,b-1,sum-1);
        }
    }
}
