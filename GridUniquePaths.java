public class GridUniquePaths {
    static int count=0;
    public static void main(String[] args) {
        uniquePaths(100,1);
    }
    static int uniquePaths(int A, int B) {
        int vis[][]=new int[A][B];
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                vis[i][j]=0;
            }
        }
        int traverseX[]={0,1};
        int traverseY[]={1,0};
        totalCount(0,0,vis,A,B,traverseX,traverseY);
        
        System.out.println(count);
        return count;
    }
    
    static void totalCount(int x,int y, int[][] vis,int A,int B, int traverseX[],int traverseY[]){
        if (atFinish(x,y,A,B))
        {count++;
        return;}
        for(int i=0;i<2;i++){
            int X=x+traverseX[i];
            int Y=y+traverseY[i];
            if (isInside(X,Y,A,B) && vis[X][Y]==0){
                vis[x][y]=1;
                totalCount(X,Y,vis,A,B,traverseX,traverseY);
                vis[x][y]=0;
            }
        }
    }
    
    static boolean atFinish(int x,int y,int A, int B ){
        return (x==A-1 && y==B-1);
    }
    
    static boolean isInside(int x,int y,int A, int B ){
    return (x<=A-1 && y<=B-1);
    }
}
