public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, total = 0;
        int res = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                res = Math.min(r - l + 1, res);
                total -= nums[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
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