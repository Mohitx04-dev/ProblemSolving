//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
    static boolean isP(int n) {
                  int i = 0;
                  String str = Integer.toString(n);
                  int j = str.length()-1;
                  while(i<j) {
                      if(str.charAt(i++)!=str.charAt(j--))  return false;
                  }
                  return true;
    }
	public static int palinArray(int[] arr, int n)
           {
                  //add code here.
                for(int i : arr) {
                    if(!isP(i)) return 0;
                }
                return 1;
           }
}