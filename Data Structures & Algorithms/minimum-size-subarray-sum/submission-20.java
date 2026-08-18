class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int n = nums.length;
        int sum = 0;
        while(r < n){
            if(sum < target){
                sum += nums[r];
                r++;
            } 
            while(sum >= target){
                res = Math.min(res, r - l);
                sum -= nums[l];
                l++;
            }
        }
        return (res == Integer.MAX_VALUE)? 0 : res;
    }
}

// 16:50

// start from left
// l = 0, r = 0
// expand till sum is less than 10
// shrink till is > 10