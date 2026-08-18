class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length; 
        int sum = 0;
        int l = 0; 
        int minLen = n+1;
        for(int r = 0; r < n; r++){
            sum+=nums[r];
            while(sum >= target){
               System.out.println(sum); 
               minLen = Math.min(minLen, r - l + 1);
               sum -= nums[l++]; 
            }
        }
        return (minLen==n+1)? 0 : minLen;
    }
}

// find -> sub array -> sum >= target

// Brute force 
// get every sub array
// get its sum
// record the sum >= target

// Optimal
// pre sum 
// Binary search

// 2 1 5 1 5  3
// 2 3 8 9 14 16

// we keep adding to currsum < 10
// if it is >=10
// we record it and 
// till it >=10 we 
// we increment left pointer an subtract that from it
// and record all the valid answers
// then,  