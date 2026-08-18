class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int l=0; int r=0; int i=0;
        while(i<res.length && l<m && r<nums2.length){
            if(nums1[l]<nums2[r]){
                res[i]=nums1[l];
                l++;
            } else {
                res[i]=nums2[r];
                r++;
            }
            i++;
        }

        while(i<res.length && l<m){
            res[i]=nums1[l];
            l++;
            i++;
        }

        while(i<res.length && r<nums2.length){
            res[i]=nums2[r];
            r++;
            i++;
        }

        for(i=0 ; i<res.length;i++){
            nums1[i] = res[i];
        }
    }
}