class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n - k;

        while(l < r){
            int m = l + (r - l)/2;
            if(Math.abs(x - arr[m]) <= Math.abs(arr[m + k] - x) ){
                r = m;
            } else {
                l = m + 1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = l; i < l + k; i++){
           res.add(arr[i]);
        }
        return res;



    }
}