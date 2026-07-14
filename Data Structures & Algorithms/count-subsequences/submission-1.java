class Solution {
    public int numDistinct(String s, String t) {
        int visited[][] = new int[s.length()][t.length()];
        for(int row[]: visited){
            Arrays.fill(row, -1);
        }
        return numRecur(s, t, 0, 0, visited);
    }

    public int numRecur(String s, String t, int ind1, int ind2, int visited[][]) {
        int max = 0;
     

        if (ind2 == t.length()) {
            return 1 ;
        }

        if (ind1 == s.length()) {
            return 0;
        }

        if(visited[ind1][ind2] !=-1){
            return visited[ind1][ind2];
        }

        if (s.charAt(ind1) == t.charAt(ind2)) {
            max = numRecur(s, t, ind1 + 1, ind2 + 1, visited);
        }

        int res = numRecur(s, t, ind1 + 1, ind2, visited);
        
        visited[ind1][ind2] = max+res;
        return (max+res);
    }
}
