class Solution {
    public int orangesRotting(int[][] grid) {
        int totalFreshFruits = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalFreshFruits = totalFreshFruits + 1;
                }

                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        // System.out.println("fresh fruits: " + totalFreshFruits);
        // System.out.println("queue: "+ q);

        int directions[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int total = 0;
        int freshFruits = 0;
        while(q.size()!= 0){

            int initialSize = q.size();
            // System.out.println("queue: "+ q.size());

            int temp = 0;
            while(initialSize != 0){
                
                int ele[] = q.poll();
                int currM = ele[0];
                int currN  =  ele[1];
                // System.out.print("Currently Processing: "+ currM+ " "+currN);
                if(grid[currM][currN] == 2){
                    
                    for(int dir[]: directions){
                       int currM_neigh= dir[0]+currM;
                       int currN_neigh=dir[1]+currN;
                      if (currM_neigh < 0 || currM_neigh == grid.length || currN_neigh < 0 || currN_neigh == grid[0].length) {
                        continue;
                      }

                       if(grid[currM_neigh][currN_neigh] == 1){
                        temp = 1;
                        freshFruits++;
                        // System.out.println(" neighbour: "+ currM_neigh + " "+ currN_neigh);
                            grid[currM_neigh][currN_neigh] = 2;
                            q.offer(new int[]{currM_neigh, currN_neigh});
                       }
                    }
                }


                initialSize--;
                
            }
            total = total+temp;
            // System.out.println("temp: "+ temp+ " total: "+total);
            
        }
        // System.out.println("freshFruits : "+ freshFruits);
        
        if(freshFruits == totalFreshFruits){
            return total;
        }

        return -1;
    }

}
