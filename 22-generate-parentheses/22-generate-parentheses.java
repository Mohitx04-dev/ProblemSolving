class Solution {
    List<String> ans;
    void fun(int open, int close, String op){
        if(open==0 && close==0){
          ans.add(op);
          return;
        } 
        if(open>0){
            String op1 = op + "(";
            fun(open-1,close,op1);
        }
        if(close>open){
            String op2 = op+')';
            fun(open,close-1,op2);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList();
        int open = n;
        int close = n;
        String op ="";
        fun(open,close,op);
        return ans;
    }
}