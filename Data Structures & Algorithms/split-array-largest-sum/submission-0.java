class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int num:nums){
            r += num;
            l = Math.max(l, num);
        }

        while(l<r){
            int mid = l + (r - l)/2;
            if(compare(mid, nums, k)){
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
        
    }

    private boolean compare(int val, int[] nums, int k){
        int parts = 1;
        int sum = 0;

        for(int num:nums){
            if(sum + num > val){
               parts++;
               sum = 0; 
            }
            sum+=num;
        }

        return parts <= k ;

    }
}

// This is similar to koko banana, shipping packages
// I have to find what to look for 
// I have to find min and max
// 

// min = max of array
// max = sum of array for k = 1

// if I divide in k parts
// I want to get minimum sum - minimize sum in k