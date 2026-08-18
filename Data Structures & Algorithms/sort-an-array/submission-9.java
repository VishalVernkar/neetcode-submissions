class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(0, nums.length - 1, nums);
        return nums;
    }

    private void mergesort(int left, int right, int[]nums){
        if(left >= right) return;
        int mid = left + (right - left)/2;
        mergesort(left, mid, nums);
        mergesort(mid + 1, right, nums);
        merge(left, mid, right, nums);
    }

    private void merge(int left, int mid, int right, int[] nums){
        int[] temp = new int[right - left + 1];
        int idx = 0;
        int l = left;
        int r = mid + 1;
        while(l <= mid && r <= right){
            if(nums[r] < nums[l]){
                temp[idx++] = nums[r++];
            } else {
                temp[idx++] = nums[l++];
            }
        }
        while(l <= mid) temp[idx++] = nums[l++];
        while(r <= right) temp[idx++] = nums[r++];

        idx = 0;
        for(int i = left; i <= right; i++){
            nums[i] = temp[idx++];
        }
    }
}

// 10:31
// 12:45

// using merge sort
// how merge sort works?
// divide and conquer
// divide till the end 
// merge as we come back up
// take first from left and right from right part
// compare -> 
// insert from left to right 

// 3 3 5 7 4 ---- 9 4 6 3 2
// 