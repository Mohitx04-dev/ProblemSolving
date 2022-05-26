class Solution {
    public String removeOuterParentheses(String s) {
        ArrayList<Character> stack = new ArrayList();
        String ans = "";
        for(char x : s.toCharArray()) {
            if(x == '(' && stack.size()==0) {
                stack.add('(');
            }
            else if(x=='(' && stack.size()!=0) {
                ans+='(';
                stack.add('(');
            }
            else if(x==')' && stack.size()==1) {
                stack.remove(0);
            }
            else{
                stack.remove(stack.size()-1);
                ans+=")";
            }
        }
        return ans;
    }
}