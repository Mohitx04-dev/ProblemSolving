class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int cur = 0;
        ArrayList<Character> stack = new ArrayList<Character>();
        for(char x : s.toCharArray()) {
            if(x=='('){
                stack.add(x);
                cur+=1;
            }
            else if(x==')' && stack.get(stack.size()-1)=='(') {
                stack.remove(stack.size()-1);
                cur-=1;
            }
            if(cur>max) {
                max = cur;
            }
        }
        return max;
    }
}