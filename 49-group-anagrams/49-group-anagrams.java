class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        HashMap<String, Integer> hs = new HashMap();
        int count=0;
        for(String x : strs) {
            char[] t = x.toCharArray();
            Arrays.sort(t);
            String temp = new String(t);
            if(hs.containsKey(temp)) ans.get(hs.get(temp)).add(x);
            else {
                hs.put(temp,count);
                ArrayList<String> arr = new ArrayList();
                arr.add(x);
                ans.add(count,arr);
                count++;
            }
        }
        return ans;
    }
}