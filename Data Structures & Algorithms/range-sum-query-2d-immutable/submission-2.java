class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        sumMatrix = new int[r + 1][c + 1];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                // at each position
                // top of sum matrix + left of sum matrix - top left of sum matrix
                // or
                sumMatrix[i + 1][j + 1] = matrix[i][j] + sumMatrix[i][j + 1] + sumMatrix[i + 1][j] - sumMatrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // sum region
        // total - top - left + top left
        // (row2+1, col2+1) - (row1+1-1, col2+1) - (row2+1, col1+1-1) + (row1+1-1, col1+1-1)
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1]  + sumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

 // 15:20

 // DP
 // 