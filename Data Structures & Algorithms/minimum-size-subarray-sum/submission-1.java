class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int l=0; int r=0;
        int sum=0;
        int minLen = n;
        while(r<n){
            if(sum < target){
                sum+=nums[r];
                r++;
            } else if(sum - nums[l] >= target){
                sum-=nums[l];
                l++;
            } else if(sum>=target) {
                minLen=Math.min(minLen, r-l);
                sum-=nums[l];
                l++;
            }
        }

        while(sum - nums[l] >= target){
            sum-=nums[l];
            l++;
        } 

        if(sum>=target) {
            minLen=Math.min(minLen, r-l);
        }


        if(sum<target && minLen==n){
            return 0;
        }
        return minLen;
    }
}