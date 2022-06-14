// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Meeting {
    public int start;
    public int end;
    Meeting(int s, int e){
        start = s;
        end = e;
    }
}
class MComparator implements Comparator<Meeting> {
    public int compare(Meeting m1, Meeting m2)
     {
         if(m2.end>m1.end) return -1;
         else if(m2.end<m1.end) return 1;
         else return 0;
     }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Meeting[] arr = new Meeting[n];
        for(int i=0; i<n; i++) {
            arr[i] = new Meeting(start[i], end[i]);
        }
        Arrays.sort(arr,new MComparator());
        int nm = 0;
        int last = 0;
        for(int i=0;i<n;i++){
            if(arr[i].start > last && arr[i].end > last) {  
                nm++;
                last = arr[i].end;
            }
        }
        return nm;
        
    }
}
        
