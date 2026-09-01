class NumMatrix {
    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        sumMatrix = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            int curRow = 0;
            for(int j = 0; j < n; j ++){
                curRow += matrix[i][j];
                sumMatrix[i + 1][j + 1] = sumMatrix[i][j + 1] + curRow;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // right bottom corner - right above - left bottom + top left corner
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


 // comput ore sum of every 2 d range and use it to get the res