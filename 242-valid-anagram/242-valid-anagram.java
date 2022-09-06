class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(char x : s.toCharArray()) {
            if(hm1.containsKey(x)) hm1.put(x,hm1.get(x)+1);
            else hm1.put(x,1);
        }
        for(char x : t.toCharArray()) {
            if(hm2.containsKey(x)) hm2.put(x,hm2.get(x)+1);
            else hm2.put(x,1);
        }
        if(hm1.equals(hm2)) return true;
        else return false;
    }
}