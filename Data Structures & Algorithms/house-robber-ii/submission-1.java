class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }

    private int helper(int[] nums, int start, int end){
        int rob1 = 0, rob2 = 0;
        for(int i = start; i < end; i++){
            int cur = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = cur;
        }

        return Math.max(rob1, rob2);
    }
}

// we have two cases rob house 1 to n - 2
// rob house 2 to n - 1