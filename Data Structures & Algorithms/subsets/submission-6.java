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

// public class Solution {

//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> subset = new ArrayList<>();
//         dfs(nums, 0, subset, res);
//         return res;
//     }

//     private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
//         if (i >= nums.length) {
//             res.add(new ArrayList<>(subset));
//             return;
//         }
//         subset.add(nums[i]);
//         dfs(nums, i + 1, subset, res);
//         subset.remove(subset.size() - 1);
//         dfs(nums, i + 1, subset, res);
//     }
// }

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
