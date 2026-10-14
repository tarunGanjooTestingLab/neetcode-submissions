class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(mp.containsKey(key)){
                List<String> res = mp.get(key);
                res.add(str);
                mp.put(key, res);
            }
            else{
                List<String> res = new ArrayList<>();
                res.add(str);
                mp.put(key, res);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            List<String> res = entry.getValue();
            ans.add(res);
        }

        return ans;
    }
}


// 
// hashmap<___, list<string>>