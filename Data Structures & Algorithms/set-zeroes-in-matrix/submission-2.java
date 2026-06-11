class Solution {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;

        // System.out.println("col: " + colLength + " rowLength: " + rowLength);
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if ((i == 0 || j == 0) && matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    } else {
                        firstCol = true;
                    }

                    if (i == 0 && j == 0) {
                        firstRow = true;
                        firstCol = true;
                    }
                }
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //   all the columns made zero
        for (int j = 0; j < colLength; j++) {
            int i = 0;
            int row = i;
            if (matrix[i][j] == 0 && j != 0) {
                while (row < rowLength) {
                    matrix[row][j] = 0;
                    row++;
                }
            }
            // System.out.print(matrix[i][j] + " ");
        }

        // for (int i = 0; i < rowLength; i++) {
        //     for (int j = 0; j < colLength; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // all the rows made zero
        for (int j = 0; j < rowLength; j++) {
            int i = 0;
            int col = 0;
            if (matrix[j][i] == 0 && j != 0) {
                while (col < colLength) {
                    matrix[j][col] = 0;
                    col++;
                }
            }
            // System.out.println(matrix[j][i] + " ");
        }

        // make the entire column and row as zero

        int col = 0;
        if (firstRow) {
            while (col < colLength) {
                matrix[0][col] = 0;
                col++;
            }
        }

        int row = 0;
        if (firstCol) {
            while (row < rowLength) {
                matrix[row][0] = 0;
                row++;
            }
        }
    }
}
