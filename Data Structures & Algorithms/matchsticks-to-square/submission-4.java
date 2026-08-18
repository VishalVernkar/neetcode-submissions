class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int num : matchsticks) sum += num;
        if(sum%4 != 0) return false;
        int target = sum/4;
        Arrays.sort(matchsticks);
        return dfs(matchsticks, 0, new int[4], target);
    }

    private boolean dfs(int[] matchsticks, int idx, int[] sides, int target){
        if(idx == matchsticks.length) return true;

        for(int i = 0; i < 4; i++){
            if(sides[i] + matchsticks[idx] > target) continue; 
            sides[i] += matchsticks[idx];
            if(dfs(matchsticks, idx + 1, sides, target)) return true;
            sides[i] -= matchsticks[idx];
            if(sides[i] == 0) break;
        }

        return false;
    }
}

// using buckets and adding each number in a bucket 
// sorting 