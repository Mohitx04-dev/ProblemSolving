//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s;
    
    // Constructor    
    GfG()
	{
        s = new Stack<Integer>();
        minEle = -1;
	}
	
    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty()) return -1;
        int v = s.pop();
        if(v==minEle) {
            if(s.isEmpty()) minEle = -1; 
            else {
                minEle = (int)1e9;
                ArrayList arr = new ArrayList<Integer>();
                while(!s.isEmpty()) {
                     minEle = Math.min(minEle,s.peek());
                     arr.add(s.pop());
                }
                for(int i=arr.size()-1; i>=0;i--) s.push((int)arr.get(i));
            }
        }
        return v;
    	// Your code here	
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(s.isEmpty()) minEle = x;
        if(x < minEle) minEle = x;
        s.push(x);
	    // Your code here	
    }	
}

