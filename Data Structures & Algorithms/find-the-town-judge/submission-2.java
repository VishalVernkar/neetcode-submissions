class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int i = 1; i < count.length; i++){
            if(count[i] == n - 1) return i;
        }
        return -1;
    }
}

// 6:37
// Question 
// find the person who is judge
// he trusts no one
// everyone trusts him

// Intuition
// this is indegree and outdegree problem
// the one person if he is a judge 
// his count of everyone trusts is = n - 1 - indegree
// if her turst no one
// his count of him trusting is = 0 - outdegree
// if both conditions meet he is a judge