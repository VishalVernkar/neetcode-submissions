class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        Set<Integer> window = new HashSet<>();
        int n = nums.length;

        for(int r = 0; r < n; r++){
            // move from left to right 
            // check before insertion
            if(window.size() > k) window.remove(nums[r - k - 1]);
            if(window.contains(nums[r])) return true;
            window.add(nums[r]);
        }
        return false;
    }
}
// 10:16

// we can use sliding window
// window of size k - using hashset
// if the i exists in the window - we have duplicates - so return true

// okay removal is wrong  - i should remvoe feom r - k

// I want to debug - understand - fix the issue quickly
// I want to understand the idea clearly before solving

// insert from the beginning
// 