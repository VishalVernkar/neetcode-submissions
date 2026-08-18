class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l=m-1; int r=n-1; int i=m+n-1;
        // compare from last index and insert the greater ones in last

        while(i>=0){
            if(r>=0 && l>=0 && nums2[r]>nums1[l]){
                nums1[i]=nums2[r];
                r--;
            } else if(l>=0){
                nums1[i]=nums1[l];
                l--;
            } else if(r>=0){
                nums1[i]=nums2[r];
                r--;
            }
            i--;
        }

    }
}