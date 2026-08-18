class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}


// search min in rotated array
// Hint log n - means bin search
// how can I binary search
// 

// [3,4,5,6,1,2]
// ascending order
// if it is rotated - in clock wise
// elements at centre will be bigger than the end
// we can go from reverse to get the small element - worst case - O(n)

// can I use first element and last element 
// and n of array to get the rotated point?

// binary search - move towars smaller value
// converge to small point 

// if 
// nums[0] > nums[n-1] - it is rotated
// smaller is

// I'll take mid point 
// check the element compare with beginning and end element
// [3,4,5,6,1,2]
// 3 5 2
// right is smaller
// left = mid + 1

// 6 1 2
// m - 1
// 5 6 2
// right is smaller
// l = mid + 1

// 6 1 2
// m = 1
// left is smaller

