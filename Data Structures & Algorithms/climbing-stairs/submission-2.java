class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int last1 = 1;
        int last2 = 1;
        int cur = 0;
        for(int i = 1; i < n; i++){
            cur = last1 + last2;
            last1 = last2;
            last2 = cur;
        }

        return cur;
    }
}

// at point we choose to take one step or two steps
// 0 1 2 3 4 5
// 8 5 3 2 1 1