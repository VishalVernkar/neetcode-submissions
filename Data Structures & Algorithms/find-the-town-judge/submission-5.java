class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n + 1];

        for(int[] p : trust){
            degree[p[0]]--;
            degree[p[1]]++;
        }

        for(int i = 1; i < n + 1; i++){
            if(degree[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}