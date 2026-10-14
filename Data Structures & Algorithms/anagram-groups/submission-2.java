class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = strs[i];

            int freq[] = new int[26];
            for(char ch : str.toCharArray()){
                freq[ch-'a']++;
            }

            StringBuilder str2 = new StringBuilder();
            for(int j=0; j<26; j++){
                str2.append('#');
                str2.append(freq[j]);
            }

            mp.computeIfAbsent(str2.toString(), k->new ArrayList<>()).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            List<String> res = entry.getValue();
            ans.add(res);
        }

        return ans;
    }
}

// O(n * mlogm) time and space: O(n * k)

// 
// hashmap<___, list<string>>