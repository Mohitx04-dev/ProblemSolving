class Solution {
    void operate(char[] arr, int i, int j) {
        if(arr[i]=='L' && arr[j]=='L') {
            for(int k=i+1; k<j; k++) {
                arr[k]='L';
            }
        }
        else if(arr[i]=='R' && arr[j]=='R') {
            for(int k=i+1; k<j; k++) {
                arr[k]='R';
            }
        }
        else if(arr[i]=='R' && arr[j]=='L'){
            int num = (i+(j-i)/2);
            if ((j-i)%2 !=0) num++;
            for(int k=i+1; k<num; k++) {
                arr[k]='R';
                arr[j-(k-i)]='L';
            }
            
        }
    }
    public String pushDominoes(String dominoes) {
        String dom = "L"+dominoes+"R";
        char[] arr = dom.toCharArray();
        int i=0;
        int j=0;
        while(j+1<arr.length){
         while(arr[j+1]=='.') j++;
         operate(arr,i,j+1);
         i=j+1;
         j=j+1;
        }
        StringBuilder ans = new StringBuilder();
        for(i=1;i<arr.length-1; i++) ans.append(arr[i]);
        return ans.toString();
    }
}