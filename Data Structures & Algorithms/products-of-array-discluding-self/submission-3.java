class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        result[0] = nums[0];
        result[1] = nums[0];

        for(int i=2; i<n; i++){
            result[i] = result[i-1] * nums[i-1];
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
