class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return nums;
    }

    private void merge(int[] nums, int l, int r){
        if(l >= r) return; 
        int m = l + (r - l)/2;
        merge(nums, l, m);
        merge(nums, m + 1, r);

        int l1 = l;
        int r1 = m;
        int l2 = m + 1;
        int r2 = r;

        int size = r - l + 1;
        int[] temp = new int[size];
        int i = 0;
        while(l1 <= r1 && l2 <= r2){
            if(nums[l1] <= nums[l2]){
                temp[i++] = nums[l1++];
            } else {
                temp[i++] = nums[l2++];
            }
        }

        while(l1 <= r1) temp[i++] = nums[l1++];
        while(l2 <= r2) temp[i++] = nums[l2++];

        for(int j = 0; j < size; j++){
            nums[l + j] = temp[j];
        }

    }

    // split the array
    // take the mid point
    // split recursively
    // then merge
    // to merge
    // place the smaller one first then bigger ones
    // 
}

// sort an array
// divide and conquer
// split the array 
// till the end 
// and take the divided part and merge