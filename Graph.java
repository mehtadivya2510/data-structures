import java.util.*;
public class Graph {
    int vertices;
    int adj[][];
    Graph(int N){
        this.vertices=N;
        this.adj=new int[N][N];
//        for(int i=0;i<N;i++){
//            for (int j=0;j<N;j++){
//                adj[i][j]=0;
//            }
//        }
    }

    public void addEdge(int u, int v){
        adj[u][v]=1;
    }

    public static void main(String[] args) {
    Graph g=new Graph(6);
    g.addEdge(0,1); g.addEdge(0,2);
    g.addEdge(0,3); g.addEdge(1,4);
    g.addEdge(1,5);

    //dfs
    Boolean vis[]=new Boolean[g.vertices];
    Arrays.fill(vis,false);
    System.out.println("DFS: ");
    dfs(g,vis,0);

    //bfs
    Arrays.fill(vis,false);
    bfs(g,vis);
}

    public static void bfs(Graph g,Boolean vis[]){
        System.out.println("\nBFS: ");
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int el=q.poll();
            System.out.print(el+" ->");
            vis[el]=true;
            for(int i=0;i<g.vertices;i++){
                if(g.adj[el][i]==1 && !vis[i])
                    q.add(i);
            }
        }
    }
    public static void dfs(Graph g,Boolean vis[],int v){
        vis[v]=true;
        System.out.print(v+" ->");
        for(int i=0;i<g.vertices;i++){
            if(g.adj[v][i]==1 && !vis[i])
                dfs(g,vis,i);
        }
    }

    
}
