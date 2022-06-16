// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}
// } Driver Code Ends


class Solution {
    void PushLast(Stack<Character> stack, Character x) {
        if(stack.empty()) stack.push(x);
        else {
            Character c = stack.peek();
            stack.pop();
            PushLast(stack,c);
            stack.push(x);
        }
    }
    void reverseS (Stack<Character> stack) {
        if(stack.empty()==true) {
            return;
        }
        Character x = stack.peek();
        stack.pop();
        reverseS(stack);
        PushLast(stack,x);
    }
    public String reverse(String S){
        //code here
        Stack<Character> stack = new Stack<Character>();
        for(char x : S.toCharArray()){
            stack.push(x);
        }
        reverseS(stack);
        String ans = "";
        while(stack.empty()!=true){
            ans+=stack.peek();
            stack.pop();
        }
        return ans;
    }

}