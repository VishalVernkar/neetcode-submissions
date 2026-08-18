class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right){
        int mid = left + (right - left)/2;

        if(left>=right) return;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right-left+1];

        int i = left;
        int j = mid + 1;
        int idx = 0;
        while(i<=mid && j<=right){
            if(nums[i] <= nums[j]){
                temp[idx++] = nums[i++];
            } else {
                temp[idx++] = nums[j++];
            }
        }

        while(i<=mid) temp[idx++] = nums[i++];
        while(j<=right) temp[idx++] = nums[j++];

        for(int k = 0; k < temp.length; k++){
            nums[k + left] = temp[k];
        }
    }
}

// Merge sort
// Divide and conquer
// use recursion
// divide into half
// till it reaches one then 
// place it in original array or new array
// how to merge?
// from left part and from right part
// how do I compare left and right part?

// let's try it I have not given a try 
// I want to follow this path no matter how difficult it is
// I have ten more mins to figure out and I want to figure it out in that time


// first divide till l<=r
// after dividing merge
//  merge to new temp array
//  then add it to original array


// [10,9,1,1,1,2,3,1]   -> 1 1 1 1 2 3 9 10
// 10 9 1 1  -  1 2 3 1 -> 1 1 9 10   1 1 2 3 
// 10 9-1 1     1 2-3 1 -> 9 10-1 1   1 2-1 3
// 10-9 1-1     1-2 3-1 -> 
// 

// use recursion
// send the start and end of split array
// do i need a new array or existing array to replace elements?

// I did not solve in time

// I don't clearly remeber this
// I have to put some time to figure out
// I remeber the splitting part 
// I don't remember merge part

// I'll try to write my steps
