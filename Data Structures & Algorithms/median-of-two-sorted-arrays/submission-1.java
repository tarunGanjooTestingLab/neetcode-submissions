class Solution {

    private double findMedian(int[] arr1, int[] arr2, int n, int m){
        int l = 0;
        int r = n;

        while(l<=r){

            // rule of length
            int partition1 = l + (r-l)/2;
            int partition2 = (n+m+1)/2 - partition1;

            // If we take 0 elements from arr1, there is nothing on the left, so use MIN_VALUE
            int aLeft = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];

            // If we take all n elements from arr1, there is nothing on the right, so use MAX_VALUE
            int aRight = (partition1 == n) ? Integer.MAX_VALUE : arr1[partition1];

            // Do the exact same for arr2
            int bLeft = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int bRight = (partition2 == m) ? Integer.MAX_VALUE : arr2[partition2];
            
            // rule of value
            if(aLeft <= bRight && bLeft <= aRight){
                if((n+m)%2==0){
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2.0;
                }
                else return Math.max(aLeft, bLeft);
            }
            else if(aLeft > bRight){
                r = partition1-1;
            }
            else l = partition1+1;
        }

        return 1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // median ->
        // rule of length -> count(left or left+1 for odd) == count(right)
        // rule of value -> elements on left <= elements on right
        
        double ans = 0;
        if(n<m) 
            ans = findMedian(nums1, nums2, n, m);
        else 
            ans = findMedian(nums2, nums1, m, n);

        return ans;
    }
}
