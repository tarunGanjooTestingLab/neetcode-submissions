class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        
        while(r<n){
            char ch = s.charAt(r);
            if(mp.containsKey(ch) && l<=mp.get(ch)){
                l = mp.get(ch) + 1;
            }

            mp.put(ch, r);
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }

        return maxLength;
    }
}
