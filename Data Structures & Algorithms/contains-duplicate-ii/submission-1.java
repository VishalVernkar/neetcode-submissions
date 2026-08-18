class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}

// nums[i] == nums[j]
// its i-j <=k

// brute force
// start from each index and see with in k
// if any duplicates are there

// Hint: sliding window
// window of size k 

// I can use window map of size k
// any other approach?
//  
