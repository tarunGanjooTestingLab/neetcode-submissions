class Solution {

    public String encode(List<String> strs) {
        // if(strs.size() == 0)
        //     return null;

        StringBuilder result = new StringBuilder();

        for(String str: strs){
            result.append(str);
            result.append("#");
            result.append("&");
            result.append("#");
        }

        return result.toString();
    }   

    public List<String> decode(String str) {

        // if(str == null)
        //     return null;

        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = str.length();

        while(i<n){

            if(str.charAt(i) == '#' && (i+1) < n && str.charAt(i+1) == '&' && (i+2) < n && str.charAt(i+2) == '#'){
                result.add(str.substring(j, i));
                i += 3;
                j = i;
                continue;
            }
            else{
                i++;
            }
        }
        
        return result;
    }
}
