class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int currSum=0;
        int res = 0;
        for(int num:nums){
            currSum+=num;
            int diff = currSum - k;
            res+= preSum.getOrDefault(diff,0);
            preSum.put(currSum, preSum.getOrDefault(currSum,0) + 1);
        }
        return res;
    }
}