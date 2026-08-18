class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // left to right
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = nums[i - 1] * res[i - 1];
        }     

        // right to left
        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = postfix * res[i];
            postfix = postfix * nums[i];
        }
        return res;
    }
}  

// 10:10

// using 
// prefix multiplication
// left to right
// right to left
// multiply both to get the res

// 