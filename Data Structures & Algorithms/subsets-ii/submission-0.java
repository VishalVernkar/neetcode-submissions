class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> list, List<List<Integer>> res){
        res.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue; 
            list.add(nums[i]);
            backtrack(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}

// 15:41

// Question
// 

// now can I try approach of problem combinations
// I think sorting ruins the subset rule
// [2, 1, 1]
// 2 1  is a subset
// but if I sort
// 1 1 2
// 1 2 is not a sub set

// brute force is using hashset for set<List<Integer>
// still this is not going to work as order is not same for duplicate list

// may be I have to try hashmap
// 

// no I don't need to think that it's not possible for 
// I want to try this
// what is the best choice to avoid list duplication
// 


// [1 2 1 1]
// 1 2
// 2 1 - X
// 2 1 1 - is ok
// now How do i take care of this?
// I may use a hash to ignore future dupliates
// but it affects other combination of set
// 