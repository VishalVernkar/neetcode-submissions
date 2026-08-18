public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0;
        int r = A.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         // double median1 = 0;
//         // double median2 = 0;

//         int n1 = nums1.length, n2 = nums2.length;

//         if(n1 == 0) return nums2[0];
//         if(n2 == 0) return nums1[0];
//         int max = Math.max(nums1[n1-1], nums2[n2-1]);
//         int min = Math.min(nums1[0], nums2[0]);
        


//         // int l = 0, r = n1 - 1;
//         // int mid = l + (r - 1)/2;
//         // double median1 = (n1 % 2 != 0)?  (double)nums1[mid] : (double)(nums1[mid] + nums1[mid + 1])/2;
//         // System.out.println(nums1[mid] + nums1[mid + 1]);
//         // System.out.println(median1);

//         // r = n2 - 1;
//         // mid = l + (r - 1)/2;
//         // double median2 = (n2 % 2 != 0)?  (double)nums2[mid] : (double)(nums2[mid] + nums2[mid + 1])/2;
//         // System.out.println(median2);


//         return (double) (max + min)/2;

//     }
// }

// looking at this, it rminded me merge sort 
// I can use it to merge these tow sorted arrays,
// if I try this, it'll be O(m+n) for sorting + log (m+n) for sorting
// so, T -> )(m+n)

// Think of other approach, directly find median of 2 arrays

// median 

// Try 1
// using mid point of both? and comparing them to move in both arrays

// 1 2 3 4 5                  6 7 8 9 10  -> 1 2 3 4 5 6 7 8 9 10 -> 
//     3                          8                  5 6   
//                                                   11
// 11


// how can I serach medain points among them 
// cases meadain has to exist 
// in one array - if m+n is odd
// if m+n is even, in one or both array


// Try 2 - not works
// get max value
// get min value
// get median between two
// see where this median can lie in which array
// if it could lie in both - search in both
// find value less than or equal to it


// Try 3 - determibne where the mid point is?
// how to move towards mid side of both arrays
// find mid point 
// take mid point of a1 and a2
// if I try to merge these indexes in one array where they will come?



// 1 3     2 4 7
// 1 2 3 4 7
// mid point index of big array -> 0 + 4 / 2 -> 2

// 1 3 - 0 -> 1
// 2 4 7 - 1 -> 4

// I f I place all the elemenets before these mid points can predict these element pos 
// no? 
// if (mid1<mid2)
// elements before <=mid1 comes before a2 and does all a1 comes before it if 



// if we try to combine elements before m1 and m2
// all those elements come before m1 and m2 when? m1 == m2?

// 1 1     2 4 7












// using meadians
// 1 3 9   2 5 7

// 3       5  

// m = 4

// -----------------
// 1 2 3 5 7 9
// 3 + 5 / 2 = 4
// median of median of both array does it work?
// no it doesn't work
// 1 2 3      4
// 2           4
// median = 3 x

// 1 3     2 7   1 2 3 7 -> 2 3 -> 2.5
// 1+7/2 => 4 => 2 3 4

// 1 3     2 4 7 ->  1 2 3 4 7 -> 3 -> 3
// 4 exists but wrong


// 1 2     3   ->  1 2 3 -> 3
// 1+3/3 => 3  -> 3


