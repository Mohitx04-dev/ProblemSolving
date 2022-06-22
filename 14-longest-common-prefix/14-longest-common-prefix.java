class Solution {
    public String longestCommonPrefix(String[] strs) {
        String min=strs[0];
        for(String t : strs) {
            if(t.length()<min.length()) {
                min = t;
            }
        }
        for(int i=min.length()-1; i>=0; i--) {
            for(String t : strs){
            if(!t.substring(0,min.length()).equals(min)) {
                min=min.substring(0,i);
                break;
             }
            }
        }    
        return min;
    }
}