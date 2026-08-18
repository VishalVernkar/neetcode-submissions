class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        int n = arr.length;

        while(l < r){
            int m = l + (r - l)/2;
            if(arr[m] < x){
                l = m + 1;
            } else {
                r = m;
            }
        }

        r = l;
        l = l - 1;

        while(r - l - 1 < k){
            if(l < 0){
                r++;
            } else if(r >= n){
                l--;
            } else if(x - arr[l] <= arr[r] - x){
                l--;
            } else {
                r++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = l + 1; i < r; i++){
           res.add(arr[i]);
        }
        return res;

       


    }
}

// 17:13

// Approach 1
// k closest elements
// binary search the position of x
// expand the window on both sided

// Aproach 2
// bnary search the window
// search for start of the window
// 