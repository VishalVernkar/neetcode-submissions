class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            // we search in smaller array so that we don't go out of index in other array 
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        // low and high represents number of elements
        int low = 0;
        int high = m; // to see if all the elements are coming to left side
        while(low<=high) {
            int cutm = (low + high)/2;
            int cutn = (m+n+1)/2 - cutm;

            // cutm == 0 -> From array 1, all the elements are part of right side of merged array
            int lm = (cutm==0)? Integer.MIN_VALUE:nums1[cutm-1];
            // cutm == m -> From array 1, all the elements are part of left side of merged array
            int rm = (cutm==m)? Integer.MAX_VALUE:nums1[cutm];

            // cutn == 0 -> From array 2, all the elements are part of right side of merged array
            int ln = (cutn==0)? Integer.MIN_VALUE:nums2[cutn-1];
            // cutn == m -> From array 2, all the elements are part of left side of merged array
            int rn = (cutn==n)? Integer.MAX_VALUE:nums2[cutn];

            if(lm <= rn && ln <= rm){
                if((m+n) % 2 == 0){
                    return (Math.max(lm,ln) + Math.min(rm, rn)) / 2.0;
                } 
                return Math.max(lm, ln);
            } else if(lm > rn){
                high = cutm - 1;
            } else {
                low = cutm + 1;
            }
        }
        return 0.0;
    }
}

// Median of two sorted arrays
// Both array are sorted
// Merging is O(m+n)
// But I have to do it in O(log(m+n))

// we can determine which point is mid point if both arrays are combined
// we can binary serch that point

// Binary search
// In general, if we assume and 
// if we take half elements from one array and other remaining half (remaining half of combined array) -> makes the elements upto mid point
// we check if this point is a mid point
// we do it by, maintaining one rule
// left half of elements <= right half of elements -> for combined array
// at this midpoint it should satisfy this condition
// how to check it?
// we take end element of left side of array 1 -> highest element from left side of array 1 
// and its next element -> we take is as smallest element from right side
// similarly we take elements from array 2

// we compare the highest element of left side-0f array 1 it should be <= smallest element of right side of array 2
// if not, the highest element of left side of array 1 should come to right side - so we do high = cut - 1;
// Similarly, we compare the highest element of left side-0f array 2 it should be <= smallest element of right side of array 1
// if not, the smallest element of right side of array 1 should come left side - so we do low = cut + 1;
// if both conditions are true it means we found the right point
// and we can calulate the median by using,
// if it is odd we use, highest among left side of arrays
// if it is even we use, max of left side + mid of right side
