class Solution {
    public int numIslands(char[][] grid) {
        HashSet<String> hashSet = new HashSet<>();

        int total = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                total = total+recursiveIslands(grid, i, j, hashSet);
            }
        }
        
        return total;
    }

    public int recursiveIslands(char[][] grid, int m , int n, HashSet<String> set ){
       int counter = 0;

       if(m<0 || m>=grid.length || n<0 ||n>=grid[0].length){
        return 0;
       }
        if(grid[m][n] != '0' && (!set.contains(m+""+n))){
            counter = 1;
            // System.out.println(" m = "+ m+ " n = "+ n);
            set.add(m+""+n);
            recursiveIslands(grid, m, n-1,set);
            recursiveIslands(grid, m, n+1,set);
            recursiveIslands(grid, m+1, n,set);
            recursiveIslands(grid, m-1, n,set);
            // System.out.println("set: "+ set);
        }
        return counter;

    }
}
