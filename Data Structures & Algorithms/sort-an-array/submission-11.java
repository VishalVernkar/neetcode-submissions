class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    private void divide(int[] nums, int l, int r){
        if(l >= r) return;

        int m = l + (r - l)/2;
        divide(nums, l, m);
        divide(nums, m + 1, r);

        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r){
        int[] merged = new int[r - l + 1];
        int l1 = l;
        int l2 = m + 1;

        int idx = 0;
        while(l1 <= m && l2 <= r){
            if(nums[l1] < nums[l2]){
                merged[idx++] = nums[l1++];
            } else {
                merged[idx++] = nums[l2++];
            }
        }

        while(l1 <= m){
            merged[idx++] = nums[l1++];
        }

        while(l2 <= r){
            merged[idx++] = nums[l2++];
        }

        for(int i = l; i <= r; i++){
            nums[i] = merged[i - l];
        }
    }
}

// divide and merge 
// divide all the way to single and merge
// recursively divide