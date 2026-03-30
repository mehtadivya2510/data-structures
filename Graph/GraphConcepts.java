package Graph;

import java.util.*;

public class GraphConcepts {
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest){
        adj.get(source).add(dest);
    }

    private static boolean detectCycleInDirectedGrph(ArrayList<ArrayList<Integer>> adj, int nodes){
        boolean[] vis=new boolean[nodes];
        for (int i=0;i<nodes;i++){
            Arrays.fill(vis,false);
            Queue<Integer> queue=new LinkedList<>();
            queue.add(i);
            vis[i]=true;
            while (!queue.isEmpty()){
                int item = queue.poll();
                ArrayList<Integer> edges= adj.get(item);
                if (edges.contains(i))
                    return true;
                for (Integer edge : edges) {
                    if (edge==i)
                        return true;
                    if (!vis[edge]){
                        vis[edge]=true;
                        queue.add(edge);
                    }
                }
            }
        }
        return false;
    }

    private static void topologicalSortingUsingDfs(ArrayList<ArrayList<Integer>> adj, int n){
        Stack<Integer> stack=new Stack<>();
        boolean[] vis=new boolean[n];
        for (int i=0;i<n;i++){
            if (!vis[i]) {
                ArrayList<Integer> edges = adj.get(i);
                for (Integer edge : edges) {
                    if (!vis[edge]) {
                        vis[edge] = true;
                        stack.push(edge);
                    }
                }
                vis[i]=true;
                stack.push(i);
            }
        }
        while (!stack.empty())
            System.out.print(stack.pop()+" ");
        System.out.println();
    }

    private static void courseSchedule(ArrayList<ArrayList<Integer>> adj, int n){
        if (detectCycleInDirectedGrph(adj,n)){
            System.out.println("Scheduling not possible");
            return;
        }
        Stack<Integer> stack=new Stack<>();
        boolean[] vis=new boolean[n];
        for (int i=0;i<adj.size();i++){
            if (!vis[i]){
                for (int edge: adj.get(i)){
                    if (!vis[edge]){
                        stack.push(edge);
                        vis[edge]=true;
                    }
                }
                stack.push(i);
                vis[i]=true;
            }
        }
        System.out.println("Course schedule: ");
        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int nodes=4;
        for (int i=0;i<nodes;i++){
            adj.add(new ArrayList<>());
        }

        // Add directed edges
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 0);

        System.out.println("Cycle present: "+ detectCycleInDirectedGrph(adj,nodes));

        int mat[][]={{1}, {}, {1}, {2}, {2}};
        adj=new ArrayList<>();
        for (int i=0;i<mat.length;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[i].length;j++){
                addEdge(adj,i,mat[i][j]);
            }
        }
        topologicalSortingUsingDfs(adj,mat.length);
        System.out.println();

        mat = new int[][]{{1}, {2}, {}, {2, 4}, {}};
        adj=new ArrayList<>();
        for (int i=0;i<mat.length;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[i].length;j++){
                addEdge(adj,i,mat[i][j]);
            }
        }
        topologicalSortingUsingDfs(adj,mat.length);

        int[][] prerequisites = { {2, 0}, {2, 1}, {3, 2}, {0,3} };
        adj=new ArrayList<>();
        for (int i=0;i<4;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
         addEdge(adj,prerequisite[0],prerequisite[1]);
        }
        courseSchedule(adj,4);
    }
}
