class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n - 1] = 1;
        for(int i = 0; i < n - 1; i++){
            left[i + 1] = nums[i] * left[i];
            right[n - 1 - i - 1] = nums[n - 1 - i] * right[n - 1 - i];
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}  

// 15:43

// using 2 pass
// once left to right
// once right to left
// multiply both
