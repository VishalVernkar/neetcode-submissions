class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1;j<n;j++){
                if(j > i+1 && nums[j-1] == nums[j]) continue;
                int target = -nums[i] - nums[j];
                int l = j+1;
                int r = n-1; 
                while(l<=r){
                    int mid = l + (r - l)/2;
                    if(nums[mid]==target){
                        res.add(List.of(nums[i], nums[j], nums[mid]));
                        break;
                    } else if(nums[mid] < target){
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }   
                }
            }
        }
        return res;
    }
}

// How to solve this?
// using brute force
// n^3

// nums[i] + nums[j] + nums[k] == 0
// using the above condition
// nums[i] + nums[j] = -nums[k]
// sort the array;
// n^2 log n

// how to tackle duplicates?
// by sorting k * 3 log 3