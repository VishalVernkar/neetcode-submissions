class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new HashSet<>(), new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, Set<Integer> skip, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(skip.contains(i)) continue; // the skip only works with prev one but not the previous form that - so I need to also move start pointer
            // how can I make sure I don't add duplicates
            // may be I need to have skip list or set
            list.add(nums[i]);
            skip.add(i);
            backtrack(nums, skip, list, res);
            skip.remove(i);
            list.remove(list.size() - 1);
        }
    }
}


// 14:50

// Question
// get all the possible arrangements of nums
// constraint all nums are unique

// steps
// 1 2 3
// options

// place each number in each place
// next place pick other number 
// once the list reaches end add it to the res


// 1 2 3
// 3 1 2

// but how so i place other numbers
// place 1 at 2
// 2 1 3
// 3 1 2
//      

// 1 2 3
// 1 3 2
// 2 1 3
// 3 1 2
// 2 3 1
// 3 2 1

// 1 2 3
// at a given pos
// for a given position
// for 1st place - 

// I choose 1
// backtrack -> I start from 1 only but I will skip the curr number added
// I remove 1 
