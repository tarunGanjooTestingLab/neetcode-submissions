class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return -1;
        
        int l = 0;
        int r = n-1;
        int mini = nums[0];

        while(l<=r){
            int mid = l + (r-l)/2;

            if(nums[mid] > nums[r]){
                l = mid+1;
            }
            else{
                mini = Math.min(mini, nums[mid]);
                r = mid-1;
            }
        }

        return mini;
    }
}
