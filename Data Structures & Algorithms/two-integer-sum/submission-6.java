class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int idx = map.get(target-nums[i]);
                if(i>idx){
                    return new int[]{idx, i};
                }
                return new int[]{i, idx};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

// using hash map