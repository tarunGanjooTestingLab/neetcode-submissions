class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        Set<Character> st = new HashSet<>();
        
        while(r<n){
            char ch = s.charAt(r);
            while(l<r && st.contains(ch)){
                st.remove(s.charAt(l++));
            }

            st.add(ch);
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }

        return maxLength;
    }
}
