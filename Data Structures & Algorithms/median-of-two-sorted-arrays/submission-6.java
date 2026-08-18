class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we need to cut the array by taking half elements frirst in nums1
        // cut at 0 --- cut at m

        if(nums2.length < nums1.length){
            return findMedianSortedArrays(nums2, nums1);
        } 
        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;

        while(l <= r){
            int cutm = l + (r - l) / 2;
            int cutn = (m + n + 1) / 2 - cutm; // +1 is to get 2 median on left if len is odd

            int lm = (cutm == 0)? Integer.MIN_VALUE : nums1[cutm - 1];
            int rm = (cutm == m)? Integer.MAX_VALUE : nums1[cutm];

            int ln = (cutn == 0)? Integer.MIN_VALUE : nums2[cutn - 1];
            int rn = (cutn == n)? Integer.MAX_VALUE : nums2[cutn];

            if(lm <= rn && ln <= rm){
                if((m + n)%2 == 0){
                    return (Math.max(lm, ln) + Math.min(rm, rn)) / 2.0;
                }
                return Math.max(lm, ln);
            } else if(lm > rn){
                r = cutm - 1;
            } else {
                l = cutm + 1;
            }
        }

        return 0.0;
    }
}

// median of two sorted arrays
// find the middle elements of combined array

// get to the left half partion point of the merged array on nums1 array and nums2 array
// the point is where
// the max element in left half of nums1 <= the right min in right half of nums2 
// the max element in left half of nums2 <= the right min in right half of nums1

// we divide the elemetns takend form nums1 based on this condition
