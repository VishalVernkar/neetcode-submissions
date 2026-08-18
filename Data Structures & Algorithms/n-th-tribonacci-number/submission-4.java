class Solution {
    public int tribonacci(int n) {
        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int tn = 0;
        for(int i = 0; i < n - 2; i++){
            tn = t0 + t1 + t2;// 0 + 1 + 1
            t0 = t1; // 1
            t1 = t2; // 1
            t2 = tn; // 2
        }
        return t2;
    }

    
}

// t3 = t0 + t1 + t2, i = 0 - 2
// t4 = t1 + t2 + t3, i = 1 - 4