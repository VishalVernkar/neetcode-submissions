/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0;
        int r = n - 1;

        while(l < r){
            int m = l + (r - l) / 2;
            if(mountainArr.get(m) < mountainArr.get(m + 1)){
                l = m + 1;
            } else {
                r = m;
            }
        }

        int peak = l;

        l = 0;
        r = peak;

        while(l <= r){
             int m = l + (r - l) / 2;
             int num = mountainArr.get(m);
             if(num == target) return m;
            if(num < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = peak + 1;
        r = n - 1;
        while(l <= r){
             int m = l + (r - l) / 2;
             int num = mountainArr.get(m);
             if(num == target) return m;
            if(num < target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }


        return -1;
    }
}

// compare values next to each other to decide if it is in a peak or not