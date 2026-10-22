class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i=0; i<n; i++){
            int height = heights[i];
            maxArea = Math.max(maxArea, height);
            int stealingIndex = i;

            if(!st.isEmpty()){
                int[] peek = st.peek();

                while(!st.isEmpty() && peek[0] > height){
                    // we found a break in the ascending pattern
                    stealingIndex = peek[1];
                    int width = i - peek[1];
                    int length = peek[0];
                    int area = length * width;
                    maxArea = Math.max(maxArea, area);

                    // remove the current element and check for remaning elements in the stack
                    st.pop();
                    if(!st.isEmpty())
                        peek = st.peek();
                }
            }
            
            st.add(new int[]{height, stealingIndex});
        }

        // now all the elements in the stack are in ascending order
        while(!st.isEmpty()){
            int[] top = st.pop();
            int width = n-top[1];
            int length = top[0];
            maxArea = Math.max(maxArea, length*width);
        }

        return maxArea;
    }
}
