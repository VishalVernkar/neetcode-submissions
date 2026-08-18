class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int target, int i, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        if(i >= nums.length || target < 0){
            return;
        }

        list.add(nums[i]);
        backtrack(nums, target - nums[i], i, list);
        list.remove(list.size() - 1);
        backtrack(nums, target, i + 1, list);
    }
}

// 12:57 - 13:10

// Question
// get all the possible combinations of number that add upto target
// numbers can repeat itself

// Steps
// at a given point
// we can repeat the same number 
// or 
// skip the number