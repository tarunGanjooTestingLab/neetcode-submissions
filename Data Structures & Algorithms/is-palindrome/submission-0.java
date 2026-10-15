class Solution {

    private String convertString(String str){
        StringBuilder s = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ' ')
                continue;
            else if(ch >= '0' && ch <= '9')
                s.append(ch);
            else{
                if(ch >= 'A' && ch <= 'Z'){
                    s.append((char)(ch + 32));
                }
                else if(ch >= 'a' && ch <= 'z')
                    s.append(ch);
            }
        }

        return s.toString();
    }

    public boolean check(String str){
        int n = str.length();
        int l = 0;
        int r = n-1;

        while(l < r){
            if(str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n <= 1)
            return true;

        String res = convertString(s);
        System.out.println(res);
        return check(res);
    }
}
