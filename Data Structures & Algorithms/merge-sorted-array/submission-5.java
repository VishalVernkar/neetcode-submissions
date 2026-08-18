class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int rm = m - 1;
        int rn = n - 1;

        int idx = nums1.length - 1;
        while(rn >= 0 && rm >= 0){
            if(nums2[rn] > nums1[rm]){
                nums1[idx--] = nums2[rn];
                rn--;
            } else {
                nums1[idx--] = nums1[rm];
                rm--;
            }
        }

        while(rm >= 0) nums1[idx--] = nums1[rm--];
        while(rn >= 0) nums1[idx--] = nums2[rn--];


    }
}
// 10:46

// merge in place

// similar to merge sort
// compare the two arrays from the end and merge them
// 