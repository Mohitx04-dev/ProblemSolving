class Solution {
    public int romanToInt(String s) {
        int ans=0;
        HashMap<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] z = s.toCharArray();
        for(int i=z.length-1; i>=0; i--) {
            ans+=map.get(z[i]);
             if(i<z.length-1) {
            if(z[i]=='I' && (z[i+1]=='V' || z[i+1]=='X')){
                ans-=2;
            }
            if(z[i]=='X' && (z[i+1]=='L' || z[i+1]=='C')){
                ans-=20;
            }
             if(z[i]=='C' && (z[i+1]=='D' || z[i+1]=='M')){
                ans-=200;
            }
            }
        }
        return ans;
    }
}