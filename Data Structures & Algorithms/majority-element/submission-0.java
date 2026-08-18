class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        int n=nums.length;
        for(int i =0; i<n; i++){
            res.put(nums[i], res.getOrDefault(nums[i],0) + 1);
        }
        int max=0;
        int num=0;
        int val=0;
        for(Integer key:res.keySet()){
            //val = res.get(key);
            if(max < res.get(key)){
                max = res.get(key);
                val = key;
            }
        }
        return val;
    }
}