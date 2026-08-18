class Solution {
    public int removeDuplicates(int[] nums) {
        // use hasset to track visited elements
        // if it is unique just insert in the ith index
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){
                nums[idx++]=nums[i];
            }
        }
        return idx;
    }

}