package src.main.java.data_structure._08_uf;

public class UF {
    private int[] eleAndGroup;      // 记录元素所在的组
    private int count;              // 记录并查集中数据分组的个数

    public UF(int N){
        // 初始化并查集分组个数
        this.count = N;
        // 初始化数组
        this.eleAndGroup = new int[N];
        // 默认i处的索引值就是i，
        // 把eleAndGroup数组的索引看做是每个节点存出得元素，把eleAndGroup数组每个索引处的值看做事该节点所在的分组
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }

    }

    public int count(){
        return count;
    }

    // 判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    //元素p所在分组的标识符
    public int find(int p){
        return eleAndGroup[p];
    }

    // 把p元素所在分组和q元素所在分组合并
    public void union(int p, int q){
        // 先安全校验
        if(connected(p, q)){
            System.out.println(p+" "+q+" 已经在同一组了~~");
            return;
        }
        // 获取p所在的组
        int pGroup = eleAndGroup[p];
        int qGroup = eleAndGroup[q];
        for (int i = 0; i < eleAndGroup.length; i++) {
            if(eleAndGroup[i]==pGroup){
                eleAndGroup[i] = qGroup;
            }
        }
        // 分组-1
        count--;
    }

}
