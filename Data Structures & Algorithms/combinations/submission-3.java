class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k, new ArrayList<>());
        return res;
    }

    private void dfs(int n, int i, int k, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
        }

        for(int j = i; j <= n; j++){
            list.add(j);
            dfs(n, j + 1, k, list);
            list.remove(list.size() - 1);
        }
    }
}

// choose a number
// choose next