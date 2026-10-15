class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int area = 0;

        int leftmax = height[0];
        int rightmax = height[n-1];

        int l = 0;
        int r = n-1;

        while(l<r){
            if(leftmax < rightmax){
                l++;
                leftmax = Math.max(leftmax, height[l]);
                area += (leftmax - height[l]);
            }
            else{
                r--;
                rightmax = Math.max(rightmax, height[r]);
                area += (rightmax - height[r]);
            }
        }

        return area;
    }
}
