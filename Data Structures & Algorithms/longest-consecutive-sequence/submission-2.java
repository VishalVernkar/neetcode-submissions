class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int i = 0;
        int n = nums.length;
        int res = 0;
        while(i < n){
            if(!set.contains(nums[i] - 1)){
                int count = 1;
                int num = nums[i];
                while(set.contains(num + 1)) {
                    num++;
                    count++;
                }
                res = Math.max(res, count);
            }
            i++;
        }
        return res;
    }
}

// 11:09

// multiple series are there
// using hashset or hash map
//  -
