class NumMatrix {
    private int[][] sumMatrix;
    int m, n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        sumMatrix = new int[m + 1][n + 1];

        for(int i = 0; i < m; i++){
            int rowSum = 0;
            for(int j = 0; j < n; j++){
                rowSum += matrix[i][j];
                sumMatrix[i + 1][j + 1] = rowSum + sumMatrix[i][j + 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] +  sumMatrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

 // by using pre sum
 // pre sum upto each 2d - from top to bottom
 // pre sum matrix
 // 3 0 1
 // 5 6 3
 // 1 2 0
 // up(from pre sum matrix) + left row sum(from main matrix)

 // range sum
 // total r c - top r - left col + top left corner