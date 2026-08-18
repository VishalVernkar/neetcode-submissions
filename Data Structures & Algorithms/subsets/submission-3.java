class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list){
        if(index == nums.length){
            res.add(list);
            return;
        }
        List<Integer> cur = new ArrayList<>();
        cur.addAll(list);
        list.add(nums[index]);
        dfs(nums, index + 1, list);
        dfs(nums, index + 1, cur);
    }
}

// subsets include the current number and not include

// I want to create a list 
// where does the list start 
// where does it end
// 


// 1 2 3
        
//         1
//       /   \
//      [1]  []
//      / \
// [1,2]  [1]
//  / \
// [1,2,3] [1, 2]  
