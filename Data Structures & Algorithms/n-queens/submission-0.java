class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int row[] = new int[n];
        int col[] = new int[n];
        int diagonalLR[] = new int[n + n];
        int diagonalRL[] = new int[n + n];
        char arr[][] = new char[n][n];
        for( int i=0; i<n ;i++){
            for(int j =0; j<n; j++){
                arr[i][j] = '.';
            }
        }
        // blockCell(row, col, diagonalLR, diagonalRL, 0, 1, n,1);
        // System.out.println("row: " + Arrays.toString(row));
        // System.out.println("col: " + Arrays.toString(col));
        // System.out.println("diagonalLR: " + Arrays.toString(diagonalLR));
        // System.out.println("diagonalRL: " + Arrays.toString(diagonalRL));

        // System.out.println(isAvailable(row, col, diagonalLR, diagonalRL, 1, 2, n));

        recursiveNquees(res, arr, row, col, diagonalLR, diagonalRL, 0, 0, n);
        return res;
    }

    public void recursiveNquees( List<List<String>> res, char arr[][], int row[], int col[], int diagonalLR[],
        int diagonalRL[], int i1, int j1, int n) {
        int i = i1;
        // System.out.println("start of the loop: i = "+ i);
        if(i == n){
            // System.out.println("result: check;");
            List<String> list = new ArrayList<>();
            for(int p = 0; p<n; p++){
                StringBuilder str = new StringBuilder("");
                for(int q = 0; q<n ; q++){
                    str.append(arr[p][q]);
                    // System.out.print(arr[p][q]+ " ");
                }
                list.add(str.toString());
                // System.out.println();
            }
            res.add(list);
        }
            for (int j = 0; j < n && i<n; j++) {
                // System.out.println("i = "+i  + " j = "+j + " isAvailable : "+ isAvailable(row, col, diagonalLR, diagonalRL, i, j, n));
                if (isAvailable(row, col, diagonalLR, diagonalRL, i, j, n)) {
                    arr[i][j] = 'Q';
                    blockCell(row, col, diagonalLR, diagonalRL, i, j, n,1);
                    recursiveNquees( res,arr, row, col, diagonalLR, diagonalRL, i + 1, j, n);
                    blockCell(row, col, diagonalLR, diagonalRL, i, j, n,0);
                    arr[i][j] = '.';


                }
            }
        
    }

    public boolean isAvailable(
        int row[], int col[], int diagonalLR[], int diagonalRL[], int i, int j, int n) {
        if (row[i] == 1) {
            return false;
        }

        if (col[j] == 1) {
            return false;
        }

        if (diagonalLR[i - j + n] == 1) {
            return false;
        }

        if (diagonalRL[i + j] == 1) {
            return false;
        }

        return true;
    }

    public void blockCell(
        int row[], int col[], int diagonalLR[], int diagonalRL[], int i, int j, int n, int replacer) {
        // System.out.println("block cell: i "+i + " "+ j);
        row[i] = replacer;
        col[j] = replacer;
        int val = i - j + n;
        diagonalLR[val] = replacer;
        diagonalRL[i + j] = replacer;

  
    }
}
