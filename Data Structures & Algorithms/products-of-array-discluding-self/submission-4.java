class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int prefix = 1;
        for(int i=0; i<n; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }
        
        int running_product = nums[n-1]; 

        for(int i=n-2; i>=1; i--){
            result[i] = result[i] * running_product;
            running_product *= nums[i];
        }

        result[0] = running_product;
        
        return result;
    }
}  
