public class Graph1 {
    public static void main(String[] args) {
    int arr[][]={{0,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,0,0}};

    Boolean vis[]={false,false,false,false};

    for(int i=0;i<arr.length;i++){
        if(!vis[i])
        dfs(arr,vis,i);
    }
    
    
}
    public static void dfs(int arr[][],Boolean vis[],int v){
        vis[v]=true;
        System.out.println(v);
        for(int j=0;j<arr[v].length;j++){
            if(!vis[j])
            dfs(arr,vis,j);
        }
    }
}
