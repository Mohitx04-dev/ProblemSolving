class Pair { 
    public int num;
    public Integer count;
    public Pair(int n) {
        this.num = n;
        count=1;
    }
    public void increase(){
        this.count++;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer,Integer> hs = new HashMap();
      Pair[] arr = new Pair[nums.length];
      int c = 0;
      for(int x : nums) {
          if(hs.containsKey(x)) {
              arr[hs.get(x)].increase();
          }
          else {
              hs.put(x,c);
              arr[c] = new Pair(x);
              c++;
          }
      }
     arr = Arrays.copyOf(arr, c);
     Arrays.sort(arr, new Comparator<Pair>() {
     @Override public int compare(Pair o1, Pair o2) {
        return o2.count.compareTo(o1.count);
     }});     
     int[] ans = new int[k];
     for(int i=0; i<k; i++) ans[i]=arr[i].num;
     return ans;
    }
}