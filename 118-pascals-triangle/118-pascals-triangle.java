class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> list = new ArrayList();  
      for(int i=0; i<numRows; i++){
          List<Integer> el = new ArrayList<Integer>();
          System.out.println(i);
          el.add(1);
          if(i>1) {
            for(int j=1; j<i; j++){
              el.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }  
          }
          if(i>0){
                        el.add(1);

          }
          list.add(el);
      }
      return list;
    }
}