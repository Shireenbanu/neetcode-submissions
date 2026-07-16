class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // if((s2.length()-s1.length())>1){
        //     return false;
        // }

        int visited1[][] = new int[s1.length()][s3.length()];
        for (int row[] : visited1) {
            Arrays.fill(row, -1);
        }

        int visited2[][] = new int[s2.length()][s3.length()];
        for (int row[] : visited2) {
            Arrays.fill(row, -1);
        }
        return isInterLeaveRecur(s1, s2, s3, 0, 0, 0, visited1, visited2);
    }

    public boolean isInterLeaveRecur(String s1, String s2, String s3, int i1, int i2, int i3,
        int visited1[][], int visited2[][]) {
        boolean res1 = false;
        boolean res2 = false;

        if ((s3.length() == i3) && (s1.length() != i1 || s2.length() != i2)) {
            // System.out.println("exit! 1");
            return false;
        }

        if (s3.length() == i3 && (s1.length() == i1 && s2.length() == i2)) {
            // System.out.println("exit! 2");

            return true;
        }

        // if (s1.charAt(i1) != s3.charAt(i3) && s2.charAt(i2) != s3.charAt(i3)) {
        //     System.out.println("exit! 3");
        //     return false;
        // }

        // if(visited[i])

        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            // System.out.println("Match: i1 = " + i1 + " i3 = " + i3);
            if (visited1[i1][i3] != -1) {
                res1 = getBooleanValue(visited1[i1][i3]);
            } else {
                res1 = isInterLeaveRecur(s1, s2, s3, (i1 + 1), i2, i3 + 1, visited1, visited2);
                visited1[i1][i3] = getNumericalValue(res1);
            }
            // if (res == false) {
            // // System.out.println(" i1 = "+ i1+ " i2 = "+i2+ " i3 = "+i3+ " res: "+ res);
            //     return false;
            // }
        }

        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            // System.out.println("Match: i2 = " + i2 + " i3 = " + i3);
            if (visited2[i2][i3] != -1) {
                res2 = getBooleanValue(visited2[i2][i3]);
            } else {
                res2 = isInterLeaveRecur(s1, s2, s3, i1, i2 + 1, i3 + 1, visited1, visited2);
                visited2[i2][i3] = getNumericalValue(res2);
            }
            // if (res == false) {
            //     // System.out.println(" i1 = "+ i1+ " i2 = "+i2+ " i3 = "+i3+ " res: "+ res);
            //     return false;
            // }
        }

        // System.out.println(" i1 = "+ i1+ " i2 = "+i2+ " i3 = "+i3);
        // System.out.println("res1 = "+ res1 + " res2 = " + res2);
        if (res1 || res2) {
            return true;
        }
        return false;
    }

    public int getNumericalValue(boolean res) {
        if (res == false) {
            return 0;
        }
        return 1;
    }

    public boolean getBooleanValue(int res) {
        if (res == 0) {
            return false;
        }
        return true;
    }
}
