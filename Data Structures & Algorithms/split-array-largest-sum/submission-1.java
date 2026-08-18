class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int num : nums){
            l = Math.max(l, num);
            r += num;
        }

        while(l < r){
            int m = l + (r - l) / 2;
            if(getSplits(nums, m) <= k){
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private int getSplits(int[] nums, int sum){
        int k = 1;
        int limit = sum;
        for(int num:nums){
            if(limit - num < 0){
                k++;
                limit = sum;
            }
            limit -= num;
        }
        return k;
    }
} 

// similar to weight capacity in days to ship?

// 
// l = max of nums
// r = total

// increas sum - reduce splits
// reduce sum - increase splits