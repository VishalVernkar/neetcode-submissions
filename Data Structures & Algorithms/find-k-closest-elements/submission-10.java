class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0, r = n - k;

        while(l < r){
            int m = l + (r - l)/2;
            if(x - arr[m] > arr[m + k] - x){
                l = m + 1;
            } else {
                r = m;
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = l; i < l + k; i++){
            res.add(arr[i]);
        }

        return res;
    }
}

// 10:16

// binary search the windwow
// search for start of window - close to the x
// search if the mid window is close or next window is close
// move based on it