class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res=0;
        for(int i=0;i<stones.length();i++){
            char stone = stones.charAt(i);
            if(jewels.contains(String.valueOf(stone))) res++;
        }
        return res;
    }
}