class Solution {
    public int removeElement(int[] nums, int val) {

        int idx = 0;
        for(int num : nums){
            if(num != val){
                nums[idx++] = num;
            }
        }
        return idx;
    }
}

// 10:08

// insert index is 0
// if we encounter a value - we don't increment insert index;