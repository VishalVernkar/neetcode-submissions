class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n;
        while(l < r){
            int mid = l + ((r - l) / 2);
            if(nums[mid] == target){
                return mid;
            } else if(target < nums[mid]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l + " " + r);
        return (l < n && nums[l] == target) ? l : -1;
    }
}

