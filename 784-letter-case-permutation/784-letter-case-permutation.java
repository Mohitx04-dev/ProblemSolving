class Solution {
    List<String> ans;
    void fun(String ip, String op){
        if(ip.length()==0) {
            ans.add(op);
            return;
        }
        char c = ip.charAt(0);
        char c1 = c;
        if(Character.isAlphabetic(c)){
           if(Character.isUpperCase(c)) c1 = Character.toLowerCase(c);
           else c1 = Character.toUpperCase(c);
           ip = ip.substring(1);
           String op1 = op+c;
           String op2 = op+c1;
           fun(ip,op1);
           fun(ip,op2);
        }
        else{
            ip = ip.substring(1);
            op+=c;
            fun(ip,op);
        }

    }
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList();
        String op="";
        fun(s,op);
        return ans;
    }
}