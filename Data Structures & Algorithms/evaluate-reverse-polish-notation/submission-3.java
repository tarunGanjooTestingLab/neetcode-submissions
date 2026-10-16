class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String str: tokens){
            if(!str.equals("*") && !str.equals("+") && !str.equals("-") && !str.equals("/")){
                // we have a integer

                int num = Integer.parseInt(str);
                st.push(num);
            }
            else{
                int num1 = st.pop();
                int num2 = st.pop();

                if(str.equals("*")){
                    st.push(num2*num1);
                }
                else if(str.equals("+")){
                    st.push(num2+num1);
                }
                else if(str.equals("-")){
                    st.push(num2-num1);
                }
                else if(str.equals("/")){
                    st.push(num2/num1);
                }
            }
        }

        return st.peek();
    }
}
