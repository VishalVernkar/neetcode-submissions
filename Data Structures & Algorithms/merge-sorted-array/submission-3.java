class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m - 1;
        int j = n - 1;
        int len = nums1.length - 1;
        while(i>=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[len--] = nums1[i--];
            } else {
                nums1[len--] = nums2[j--];
            }
        }

        while(i>=0 && len>=0) nums1[len--] = nums1[i--];
        while(j>=0 && len>=0) nums1[len--] = nums2[j--];
    }
}

// this is similar to mergre sort
// create a temp array then update it in orginal

// or I can merge from end based on bigger numbers