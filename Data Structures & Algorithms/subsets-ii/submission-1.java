class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> list){
        res.add(new ArrayList<>(list));
        if(idx == nums.length) return;
        
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}

// I need to handle duplicates 
// at the same position I do not want the same number again
// 

// at a point choose the number - not choose the number - continue.
// sort the array to handle duplicates
// 1 1 2
// 
