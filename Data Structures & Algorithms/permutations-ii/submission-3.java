class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> res){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            perm.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, perm, res);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }
}

// I want to understand - If I'm not I want to give time to them 
// Now I'm able to understand the problems
// the steps to solve it
// but I'm not able to understand, how recursion flows

// right now, 
// I'm following time -> following form

// 5:35 - 5:45 +5:55 +6:00

// Questions
// get all the permutation of the nums,
// duplicate numbers are there, 
// so no duplicate permuatations

// 1 1 2
// 1 1 2

// would appear two times, as first 1 and 2nd one are different in code

// backtracking - recurision
// choose
// backtrack 
// unchoose

// approaches I know
// using boolean array 
// using swap in place approach - either use hashset or find duplicate while traversing
// 

// boolean approach
// algo
// sort the array to handle duplicates
// using boolean array to track visited numbers
// if it is already visited - we can pick next duplicate
// if it is not visited already - we should skip the duplicate - because the same number at the same position again creates duplicates
// then if the arraylist is of size - we have one complete permtation of the nums - add to res
// else 
// traverse the nums array
// check if it is not used in its previous occurance 
// add num to the result from current index
// update true for index in boolean array
// backtrack to slect next number
// update flase for index in boolean array
// remove the number - continue to select next number



// I'll only use duplicates if previous duplicate is already used
// the duplicates - as they are next to each other
// all the duplicates are included this way
// 1 1 1 1
// included
// for first occurance of 1
// 1 
// 1 1
// 1 1 1 
// 1 1 1 1
// not included
// for next occurance - when the first occurance boolean becomes false - everything will be skipped - as it would create same pattern if continued
// so 


// I also want to try swap approach - I'll do it later

























// I don't need to think about past perspective, I beleive in what I want now. I have oppurtunity to learn now - and I'm capable of doing it