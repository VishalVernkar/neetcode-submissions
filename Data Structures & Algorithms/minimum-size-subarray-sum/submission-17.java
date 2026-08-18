public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int res = n + 1;
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                int curSum = prefixSum[mid + 1] - prefixSum[i];
                if (curSum >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l != n) {
                res = Math.min(res, l - i + 1);
            }
        }

        return res % (n + 1);
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