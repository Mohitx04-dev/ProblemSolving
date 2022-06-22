class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ");
        s=s.trim();
        String[] arr=s.split(" ");
        String[] r=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            
            r[i]=arr[arr.length-1-i];
            
        }
     String rt="";
          for(int i=0;i<r.length-1;i++){
            rt+=r[i]+" ";
        }
        rt+=r[r.length-1];
        return rt;
    }
}