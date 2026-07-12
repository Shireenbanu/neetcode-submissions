class Solution {
    public int minDistance(String word1, String word2) {
        int visited[][] = new int[word1.length()][word2.length()];
        for (int row[] : visited) {
            Arrays.fill(row, -1);
        }
        int res = minDistanceRecur(word1, word2, 0, 0, visited);

        return res;
    }

    public int minDistanceRecur(String t1, String t2, int ind1, int ind2, int[][] visited) {
        int max = 0;
        if (t1.length() == ind1) {
            // System.out.println("maxed out! " + (t2.length() - ind2));
            return (t2.length() - ind2);
        }

        if (t2.length() == ind2) {
            // System.out.println("Maxed on t2 " + (t1.length() - ind1));
            return (t1.length() - ind1);
        }

        if (visited[ind1][ind2] != -1) {
            return visited[ind1][ind2];
        }

        if (t1.charAt(ind1) == t2.charAt(ind2)) {
            max = minDistanceRecur(t1, t2, ind1 + 1, ind2 + 1, visited);
        } else {
            // replace
            int replace = 1 + minDistanceRecur(t1, t2, ind1 + 1, ind2 + 1, visited);
            // delete
            int delete = 1 + minDistanceRecur(t1, t2, ind1 + 1, ind2, visited);
            // insert
            int insert = 1 + minDistanceRecur(t1, t2, ind1, ind2 + 1, visited);

            max = Math.min(replace, Math.min(delete, insert));
        }

        // System.out.println(" for: ind1 " + ind1 + " ind2 " + ind2 + "  max:  " + max);
        visited[ind1][ind2] = max;
        return max;
    }
}
