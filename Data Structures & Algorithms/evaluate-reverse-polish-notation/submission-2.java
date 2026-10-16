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

                //System.out.println("num1: " + num1 + " and num2: " + num2);

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

                //System.out.println("after operation element to insert: " + st.peek());
            }
        }

        return st.peek();
    }
}
