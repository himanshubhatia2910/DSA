class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i: arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        Set<Integer> s=new HashSet<>();
        for(int x: freq.values()){
            s.add(x);
        }
        return freq.size() == s.size();
    }
}