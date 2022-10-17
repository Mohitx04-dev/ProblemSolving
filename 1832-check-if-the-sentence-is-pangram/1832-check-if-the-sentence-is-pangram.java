class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hs = new HashSet();
        for(char x : sentence.toCharArray()) hs.add(x);
        for(int i=97; i<123; i++) if(!hs.contains((char)i)) return false;
        return true;
    }
}