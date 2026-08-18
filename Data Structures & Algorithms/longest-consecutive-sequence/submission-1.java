class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i]-1)){
                int length = 1;
                while(set.contains(nums[i]+length)){
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}
