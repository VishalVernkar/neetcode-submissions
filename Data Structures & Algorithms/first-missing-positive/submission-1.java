class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] res = new boolean[n+1];
        for(int num:nums){
            if(num > 0 && num <= n) res[num] = true;
        }

        for(int i = 1; i <= n; i++){
            if(!res[i]) return i;
        }

        return n + 1;
    }
}

// using  boolean array
// the positive number should be +1 to n