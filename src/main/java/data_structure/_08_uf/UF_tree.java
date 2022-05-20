package src.main.java.data_structure._08_uf;

public class UF_tree {
    private int[] eleAndGroup;      // 记录元素所在的组
    private int count;              // 记录并查集中数据分组的个数

    public UF_tree(int N){
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
        while (true){
            // 判断当前元素p的父节点是否等于自己，如果是，则说明找到根节点了
            if(p==eleAndGroup[p]){
                return eleAndGroup[p];
            }
            // 如果不是自己，则让 p = eleAndGroup[p]， 继续往右遍历，直到找到根节点
            p = eleAndGroup[p];
        }
    }

    // 把p元素所在分组和q元素所在分组合并
    public void union(int p, int q){
        // 先安全校验
        if(connected(p, q)){
            return;
        }
        // 获取p所在的组
        int pGroup = find(p);
        int qGroup = find(q);
        // 则只需要将p元素所在树根结点的父结点设置为q元素的根结点即可；
        eleAndGroup[pGroup] = qGroup;
        // 分组-1
        count--;
    }

}
