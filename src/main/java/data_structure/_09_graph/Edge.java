package src.main.java.data_structure._09_graph;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;          // v, 和w是边的两个顶点
    private double weight;     // weight 是这条边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double get_weight() {
        return weight;
    }

    // 获取边上的一个节点
    public int either() {
        return v;
    }

    // 获取边上除了顶点vertex的另外一个节点
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else {
            return v;
        }
    }

    @Override
    public int compareTo(Edge that) {
        // < -1
        // > 1
        // = 0
        return Double.compare(this.get_weight(), that.get_weight());
    }
}
