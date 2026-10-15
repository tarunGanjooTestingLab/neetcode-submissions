class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        suffix[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }

        int area = 0;

        for(int i=1; i<n-1; i++){
            int val = height[i];
            int max_boundry = Math.min(prefix[i-1], suffix[i+1]);
            int final_area = max_boundry - val;

            if(final_area > 0) area += final_area;
        }

        return area;
    }
}
