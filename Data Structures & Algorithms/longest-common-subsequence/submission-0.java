class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int visited[][] = new int[text1.length()][text2.length()];

        for(int[]row : visited){
            Arrays.fill(row, -1);
        }
        
        return recurLongest(text1, text2, 0, 0,visited); 
    }

    public int recurLongest(String t1, String t2, int ind1, int ind2, int[][] visited){
        int len = 0;

        if(t1.length() == ind1 || t2.length() == ind2){
            return len;
        }

        if(visited[ind1][ind2] != -1){
            return visited[ind1][ind2];
        }

        if(t1.charAt(ind1) == t2.charAt(ind2)){
            len = 1+recurLongest(t1, t2, ind1+1, ind2+1, visited);
            // System.out.println("its a match: "+len);
        }
        else
        {
            int val1 = recurLongest(t1, t2, ind1+1, ind2, visited);
            int val2 = recurLongest(t1, t2, ind1, ind2+1, visited);
            len = Math.max(val1, val2);
        }

        // System.out.println("for: ind1 = "+ ind1+ " ind2 = "+ind2+ " len = "+ len);
        visited[ind1][ind2] = len;
        return len;
    }
}
