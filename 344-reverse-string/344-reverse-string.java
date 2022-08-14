class Solution {
    public void reverseString(char[] s) {
        int st=0;
        int l=s.length-1;
        while(st<=l) {
            char x = s[st];
            s[st] = s[l];
            s[l] = x;
            st++;
            l--;
        }
    }
}