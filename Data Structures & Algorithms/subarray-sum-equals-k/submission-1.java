class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // to count values already equal to k as subarray
        int res = 0, currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            int diff = currSum - k;
            res += map.getOrDefault(diff, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}
// currsum - prevsum = k
// 
// using hashmap to store all the current sum and use it to find the tagrget