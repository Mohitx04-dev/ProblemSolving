class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<>();
      for(Character x : s1.toCharArray()) {
          if(freq.containsKey(x)) freq.put(x,freq.get(x)+1);
          else freq.put(x,1);
      }
      int start = 0;
      int end = s1.length()-1;
      while(end<s2.length()) {
          String temp = s2.substring(start,end+1);
           HashMap<Character,Integer> freq2 = new HashMap();
           for(Character x : temp.toCharArray()) {
              if(freq2.containsKey(x)) freq2.put(x,freq2.get(x)+1);
              else freq2.put(x,1);
           }
           if(freq.equals(freq2)){
              return true;
          }
          start++;
          end++;
      }
        return false;
    }
}