class Solution {
    public boolean isValid(String s) {

        if(s.length()%2 != 0)
            return false;

        Stack<Character> st = new Stack();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')' || ch == '}' || ch == ']'){
                if (ch == ')') {
                    if (!st.isEmpty() && st.peek() == '(') st.pop();
                    else return false;
                } else if (ch == '}') { 
                    if (!st.isEmpty() && st.peek() == '{') st.pop();
                    else return false;
                } else if (ch == ']') {  
                    if (!st.isEmpty() && st.peek() == '[') st.pop();
                    else return false;
                }
            }
            else st.push(ch);        
        }

        return st.size() == 0 ? true : false;
    }
}
