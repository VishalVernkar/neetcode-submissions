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
        // find pivot
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            int mid = mountainArr.get(m);
            int next = mountainArr.get(m + 1);
            if (mid < next) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int peak = l;
        int left = mountainArr.get(0);
        int mid = mountainArr.get(peak);
        int right = mountainArr.get(n - 1);

        r = peak;
        l = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int num = mountainArr.get(m);
            if (num == target) {
                return m;
            }

            if (num < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        l = peak + 1;
        r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int num = mountainArr.get(m);
            if (num == target) {
                return m;
            }

            if (num > target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}

// find peak
// left -----peak-----right
// mid
// left < mid - mid > right

// 1 2 3 4 2 1 -- -- -- -- -- -0 1 2 3 4 5
//     - i

//         m = 2 3 < 4

//     l = 3 m = 4 2 < 1

//     r = 4 m = 3 4 < 2

//     r = 3 l = 3