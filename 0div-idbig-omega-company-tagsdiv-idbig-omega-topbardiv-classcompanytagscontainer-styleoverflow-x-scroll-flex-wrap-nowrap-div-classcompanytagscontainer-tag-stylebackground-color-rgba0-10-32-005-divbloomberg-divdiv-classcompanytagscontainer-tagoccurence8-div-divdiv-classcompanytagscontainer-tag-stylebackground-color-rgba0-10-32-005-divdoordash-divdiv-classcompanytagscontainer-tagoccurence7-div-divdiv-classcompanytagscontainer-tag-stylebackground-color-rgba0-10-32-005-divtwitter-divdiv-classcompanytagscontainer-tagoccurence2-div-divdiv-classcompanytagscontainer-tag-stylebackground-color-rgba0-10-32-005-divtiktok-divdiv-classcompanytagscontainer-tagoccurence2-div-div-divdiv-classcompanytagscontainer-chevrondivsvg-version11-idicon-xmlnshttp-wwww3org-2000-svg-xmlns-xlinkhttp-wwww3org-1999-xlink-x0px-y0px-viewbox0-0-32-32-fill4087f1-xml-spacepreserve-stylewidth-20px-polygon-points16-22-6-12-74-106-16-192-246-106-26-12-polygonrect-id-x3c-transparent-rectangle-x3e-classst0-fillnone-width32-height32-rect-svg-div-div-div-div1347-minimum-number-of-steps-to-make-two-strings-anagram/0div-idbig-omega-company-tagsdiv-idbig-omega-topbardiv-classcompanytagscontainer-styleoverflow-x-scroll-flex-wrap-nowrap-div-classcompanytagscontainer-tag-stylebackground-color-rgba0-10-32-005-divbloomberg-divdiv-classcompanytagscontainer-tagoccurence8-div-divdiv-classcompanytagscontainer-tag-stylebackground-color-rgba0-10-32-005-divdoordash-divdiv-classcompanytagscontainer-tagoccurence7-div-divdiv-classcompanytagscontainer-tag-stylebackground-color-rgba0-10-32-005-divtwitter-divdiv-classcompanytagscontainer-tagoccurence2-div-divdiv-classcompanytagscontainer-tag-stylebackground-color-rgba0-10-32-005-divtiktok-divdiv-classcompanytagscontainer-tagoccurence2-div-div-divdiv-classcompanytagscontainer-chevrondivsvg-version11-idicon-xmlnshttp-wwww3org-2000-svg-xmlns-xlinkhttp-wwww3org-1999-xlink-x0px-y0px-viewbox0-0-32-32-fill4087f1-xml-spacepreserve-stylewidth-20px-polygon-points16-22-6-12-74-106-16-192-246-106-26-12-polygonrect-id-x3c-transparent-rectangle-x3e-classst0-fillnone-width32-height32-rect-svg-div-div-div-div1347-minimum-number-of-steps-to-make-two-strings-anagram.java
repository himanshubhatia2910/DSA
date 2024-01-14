class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer>hs=new HashMap<>();
        int cnt=0;
        for(char c:t.toCharArray() ){
            hs.put(c,hs.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!hs.containsKey(ch))
            cnt++;
            else{
                hs.put(ch,hs.get(ch)-1);
                if(hs.get(ch)==0)
                hs.remove(ch);
            }
        }
return cnt;
    }
}