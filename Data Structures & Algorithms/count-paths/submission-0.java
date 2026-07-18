class Solution {
    public int uniquePaths(int m, int n) {
       int visited[][] = new int[m][n];
        for(int row[]: visited){
            Arrays.fill(row, -1);
        }
       return uniquePathEncore(m, n, 0, 0, visited);

    }

    public int uniquePathEncore(int m, int n, int i, int j, int [][] visited){

        if((m-1) == i && (n-1) == j){
            return 1;
        }

        if(i>=m || j>=n ){
            return 0;
        }

        if(visited[i][j]!= -1 ){
            return visited[i][j] ;
        }

        int res1 = uniquePathEncore(m, n, i, j+1, visited);
        //  System.out.println("res1: "+ res1);
        int res2 = uniquePathEncore(m, n, i+1, j, visited);
        // System.out.println("m n "+ i+" "+j+ " is "+(res1+res2));

        visited[i][j] = (res1+res2);
        return (res1+res2);
       
        
    }
}
