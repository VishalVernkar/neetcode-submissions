class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = (m * n) - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int num = matrix[mid/n][mid%n];
            if(num == target){
                return true;
            } else if(num < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

//   0 1 2 3
// 0 0 1 2 3
// 1 1 2 3 4
// 2 2 3 4 5

// m * n
// 12
// j%n
// 0 1 2 3 
// 4 5 6 7
// 8 9 10 11

// j % m + 1
// j / 3
// 0 0 0 0
// 1 1 1 1
// 2 2 2 2