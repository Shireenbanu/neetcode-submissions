class Solution {
    public int climbStairs(int n) {
        int visited[] = new int[n+1];

        Arrays.fill(visited, -1);

        return climbStairEncore(n, visited);
    }

    public int climbStairEncore(int target, int[] visited){

        if(target == 0){
            return 1;
        }

        if(target<0){
            return 0;
        }

        if(visited[target] != -1){
            return visited[target];
        }

        int res =0;

        res = climbStairEncore(target-1, visited)+climbStairEncore(target-2, visited);
        
        visited[target] = res;
        return res;
    }
}
