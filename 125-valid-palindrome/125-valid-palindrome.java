class Solution {
    public boolean isPalindrome(String s) {
       String res = "";
       for(char x : s.toCharArray()) {
           if(Character.isLetterOrDigit(x)) res+=Character.toLowerCase(x);
       }
       for(int i=0; i<res.length()/2; i++){
           if(res.charAt(i)!=res.charAt(res.length()-i-1)) return false;
       }
       return true;
    }
}