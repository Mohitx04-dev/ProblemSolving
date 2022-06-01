class Solution {
    public int lengthOfLongestSubstring(String s) {
        String max="";
        String cur="";
        for(char x : s.toCharArray()) {
            if(cur.contains(Character.toString(x))) {
                int idx = cur.indexOf(x);
                cur = cur.substring(idx+1);
                cur += x;
            }
            else{
                cur+=x;
            }
            if(cur.length()>max.length()){
                max=cur;
            }
            System.out.println(max + " " + cur);
        }
        return max.length();
    }
}