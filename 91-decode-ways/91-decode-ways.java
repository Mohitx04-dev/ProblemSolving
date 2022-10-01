class Solution {
    static HashMap<Integer,Integer> hs;
    int fun(String ip, int idx){
            if(hs.containsKey(idx)) return hs.get(idx);
            if(idx==ip.length()) return 1;
            if(ip.charAt(idx)=='0') return 0;
            int ans = fun(ip,idx+1);
            int num1=0;
            if(idx+1<ip.length()) num1 = Integer.parseInt(ip.substring(idx,idx+2));
            if(num1>0 && num1<=26) ans+=fun(ip,idx+2); 
            hs.put(idx,ans);
            return ans;
    }
    public int numDecodings(String s) {
        hs=new HashMap();
        return fun(s,0);
    }
}