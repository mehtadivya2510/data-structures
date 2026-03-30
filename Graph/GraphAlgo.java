package Graph;

import java.util.*;

public class GraphAlgo {
    private static void dijkstraAlgo(ArrayList<ArrayList<Node>> adj, int nodes, int source){
        int dist[]=new int[nodes];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int []> pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0,source});
        dist[source]=0;
        while (!pq.isEmpty()){
            int[] temp=pq.poll();
            int d= temp[0];
            int edge= temp[1];
            for (Node node: adj.get(edge)){
                if (dist[node.edge]>d+node.weight){
                    dist[node.edge]=d+node.weight;
                    pq.add(new int[]{d+node.weight,node.edge});
                }
            }
        }

        for (int item:dist){
            System.out.print(item+" ");
        }
        System.out.println();
    }

    private static int[] bellmanFordAlgo(int[][] edges , int nodes, int source){
        int dist[]=new int[nodes];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        for (int i=0;i< nodes;i++){
            for (int j=0;j<edges.length;j++){
                int u= edges[j][0];
                int v= edges[j][1];
                int wt= edges[j][2];
                if (dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    if (i==nodes-1)
                        return new int[]{-1};
                    dist[v]=dist[u]+wt;
                }
            }
        }
        return dist;
    }

    private static void floydAlgo(){

    }

    private static void primMSTAlgo(){

    }

    private static void kruskalMSTAlgo(){

    }

    private static void addEdge(ArrayList<ArrayList<Node>> adj, int u,int v,int w){
        adj.get(u).add(new Node(v,w));
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        int nodes=5;

        for (int i=0;i<nodes;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 4, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 2, 3, 2);
        addEdge(adj, 3, 4, 10);

        dijkstraAlgo(adj,nodes,0);

        int[][] edges = new int[][] {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };
        int res[]=bellmanFordAlgo(edges,edges.length,0);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}

class Node{
    int edge;
    int weight;
    Node(int edge, int weight){
        this.edge=edge;
        this.weight=weight;
    }
}
