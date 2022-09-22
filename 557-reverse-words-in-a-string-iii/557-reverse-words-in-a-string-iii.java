class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String ans="";
        int c=0;
        for(String t : arr) {
            StringBuilder st = new StringBuilder();
            st.append(t);
            st.reverse();
            ans+=st;
            c++;
            if(c!=arr.length) ans+=" ";
        }
        return ans;
    }
}