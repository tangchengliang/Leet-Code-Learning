package src.main.java.data_structure._09_graph;

import java.util.ArrayDeque;

public class DiGraph {
    private final int V;
    private int E;
    private ArrayDeque<Integer>[] adj;

    public DiGraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new ArrayDeque[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayDeque<Integer>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    public ArrayDeque<Integer> get_adj(int k){
        return adj[k];
    }

    public void addEdge(int v, int w){
        // v--->指向w
        adj[v].offer(w);
        E++;
    }

    public DiGraph reverse(){
        DiGraph r = new DiGraph(V);
        for (int v = 0; v < V; v++) {
            for(Integer w: adj[v]){
                r.addEdge(w,v);
            }
        }
        return r;
    }
}
