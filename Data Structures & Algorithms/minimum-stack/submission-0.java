class MinStack {

    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val, val});
        }
        else{
            int[] topEle = st.peek();
            st.push(new int[]{val, Math.min(val, topEle[1])});
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            int[] topEle = st.peek();
            return topEle[0];
        }
        else return -1;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            int[] topEle = st.peek();
            return topEle[1];
        }
        else return -1;
    }
}
