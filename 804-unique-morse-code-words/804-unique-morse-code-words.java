class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character,String> map = new HashMap();
        for(int i='a'; i<='z'; i++) {
            map.put((char)i,codes[i-97]);
        }
        HashMap<String,Boolean> t = new HashMap();
        int ans=0;
        for(String x : words) {
            String ms="";
            for(char c : x.toCharArray()) {
                ms+=map.get(c);                
            }
            if(!t.containsKey(ms)){
                ans++;
                t.put(ms,true);
            }
        }
        return ans;
    }
}