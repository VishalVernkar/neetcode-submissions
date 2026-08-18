class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        sumMatrix = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sumMatrix[i+1][j+1] = matrix[i][j] + sumMatrix[i +1 - 1][j + 1] + sumMatrix[i + 1][j + 1 - 1] - sumMatrix[i + 1 - 1][j + 1 - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottom = sumMatrix[row2][col2];
        int top = sumMatrix[row1-1][col2];
        int left = sumMatrix[row2][col1-1];
        int topcorner = sumMatrix[row1-1][col1-1];
        return bottom - top - left + topcorner;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

// I should stop or I'll exhaust my mind with random rush thinking
 // How can I calculate prefix sum of matrix?
 // 