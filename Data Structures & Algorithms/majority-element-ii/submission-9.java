class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1) return List.of(nums[0]);
        int num1 = nums[0];
        int num2 = nums[1];
        int count1 = 0;
        int count2 = 0;

        for(int num : nums){
            if(num == num1){
                count1++;
            } else if(num == num2){
                count2++;
            } else if(count1 == 0){
                num1 = num;
                count1++;
            } else if(count2 == 0){
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for(int num : nums){
            if(num == num1) count1++;
            else if(num == num2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length/3) res.add(num1);
        if(count2 > nums.length/3) res.add(num2);

        return res;
        
    }
}

// using boyer moore voting algorithm
// we can only have two majority elements
// so 
// we use two pointer - we update its count 
// once any other num comes we update it to new num