class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m)
            return false;

        int []charFrequency = new int[26];
        
        // adding the frequency of s and decreasing the frequency t because
        // both have same lenght as proved above
        for(int i=0; i<n; i++){
            charFrequency[s.charAt(i)-'a']++;
            charFrequency[t.charAt(i)-'a']--;
        }

        // traversing over the array to check if the frequency is 0 or not
        for(int count : charFrequency){
            if(count != 0)
                return false;
        }

        return true;
    }
}
