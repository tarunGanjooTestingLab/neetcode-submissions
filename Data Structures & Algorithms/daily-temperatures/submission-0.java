class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=n-1; i>=0; i--){

            int ele = temperatures[i];

            if(!st.isEmpty()){
                while(!st.isEmpty()){
                    int[] topEle = st.peek();
                    if(topEle[0] > ele){
                        result[i] = topEle[1] - i;
                        st.push(new int[]{ele, i});
                        break;
                    }
                    else{
                        st.pop();
                    }
                }

                if(st.isEmpty()){
                    result[i] = 0;
                    st.push(new int[]{ele, i});
                }
            }
            else{
                result[i] = 0;
                st.push(new int[]{ele, i});
            }

        }

        return result;
    }
}
