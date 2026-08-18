class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int sum=0;
        int minLen=Integer.MAX_VALUE;

        int l=0;
        int r=0;
        for(r=0;r<n;r++){
            sum+= nums[r];
            while(sum>=target){
                minLen = Math.min(minLen, r-l+1);
                sum-=nums[l];
                l++;
            }
        }

        return (minLen == Integer.MAX_VALUE)? 0 : minLen;
    }
}