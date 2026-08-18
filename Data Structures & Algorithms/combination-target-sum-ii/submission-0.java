class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> combination, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(combination));
        }


        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;
            combination.add(nums[i]);
            backtrack(nums, target - nums[i], i + 1, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}
// 14:00

// Question
// get the number that add upto given target
// it has to be unique
// same comnations should not me there
// For example:
// there are 2 2's
// so for target 8 -> we hould only have -> 1 -> 2, 6

// steps
// to filter the duplicates 
// we can sort the array
// to get all the combinations
// we choose the possible options at each point
// so at eacch point
// for target
// we can add the current number or not add the current number

// algo
// sort the numbers
// recursive function - 
    // for each number from start - get all the possible combinations for number ahead of it
    // we filter duplicates by i > start and prev number == start
    // for current list - we add the number
    // we recursively call the funcion - and update the target by reducing the current number
    // we try other possiblity - to remove current number - from the list
 
