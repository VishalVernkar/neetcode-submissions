class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n < 3){
            return n == 1? nums[0] : Math.max(nums[0], nums[1]);
        }

        nums[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }

        return Math.max(nums[n - 1], nums[n - 2]);
    }
}

// rob the current house or not rob the current house
// at a point - rob the house - move to i + 2
// or 
// not rob the house - move to i + 1
// store the max of them 
