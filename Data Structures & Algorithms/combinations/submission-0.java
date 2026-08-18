class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n + 1, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> list, List<List<Integer>> res){
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        } 

        for(int i = start; i < n; i++){
            list.add(i);
            backtrack(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}

// 14:24

// Question
// From  1 - n
// give all posible combinations of size k

// steps
// ex: 1 2 3 k = 2
// 1 2
// 2 3
// 1 3
// no duplicates

// at a given point 
// it is like a subset of size = 2
// we can get all the subset and only take list of size k

// algo
// current subset
// if subset size == k -> add to res -> return
// for 1 to n
// add(i)
// backtrack
// remove (i)