class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> quad = new ArrayList<>(); 

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // we have to get nested loops till we are left with last two values to be found using two pointers
        Arrays.sort(nums);
        ksum(nums, target, 0, 4);
        return res;
    }

    public void ksum(int[] nums, long target, int start, int k){
        if(k==2){
            int l=start; int r = nums.length - 1;
            while(l<r){
                long sum = nums[l] + nums [r];
                if(sum > target){
                    r--;
                } else if(sum < target){
                    l++;
                } else {
                    List<Integer> list = new ArrayList<>(quad);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++; r--;
                    while(l<r && nums[l] == nums[l-1]) l++;
                    while(l<r && nums[r] == nums[r+1]) r--;
                }
            }
            return;
        }

        for(int i=start;i<nums.length-k+1;i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            quad.add(nums[i]);
            ksum(nums, target-nums[i], i+1, k-1);
            quad.remove(quad.size()-1);
        }
    }
}