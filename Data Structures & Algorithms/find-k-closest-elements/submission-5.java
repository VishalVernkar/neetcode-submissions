class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;

        while(l < r){
            int mid = l + (r - l)/2;
            if(x - arr[mid] > arr[mid+k] - x){
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = l; i < l + k; i++){
            res.add(arr[i]);
        }

        return res;
    }
}

// two ways this can be solved

// one 
// using binary search
// first find where x lies 
// then get its closest elments using |a - x| < |b - x|

// two 
// binary seacrh the window
// How?

// search start of the window



