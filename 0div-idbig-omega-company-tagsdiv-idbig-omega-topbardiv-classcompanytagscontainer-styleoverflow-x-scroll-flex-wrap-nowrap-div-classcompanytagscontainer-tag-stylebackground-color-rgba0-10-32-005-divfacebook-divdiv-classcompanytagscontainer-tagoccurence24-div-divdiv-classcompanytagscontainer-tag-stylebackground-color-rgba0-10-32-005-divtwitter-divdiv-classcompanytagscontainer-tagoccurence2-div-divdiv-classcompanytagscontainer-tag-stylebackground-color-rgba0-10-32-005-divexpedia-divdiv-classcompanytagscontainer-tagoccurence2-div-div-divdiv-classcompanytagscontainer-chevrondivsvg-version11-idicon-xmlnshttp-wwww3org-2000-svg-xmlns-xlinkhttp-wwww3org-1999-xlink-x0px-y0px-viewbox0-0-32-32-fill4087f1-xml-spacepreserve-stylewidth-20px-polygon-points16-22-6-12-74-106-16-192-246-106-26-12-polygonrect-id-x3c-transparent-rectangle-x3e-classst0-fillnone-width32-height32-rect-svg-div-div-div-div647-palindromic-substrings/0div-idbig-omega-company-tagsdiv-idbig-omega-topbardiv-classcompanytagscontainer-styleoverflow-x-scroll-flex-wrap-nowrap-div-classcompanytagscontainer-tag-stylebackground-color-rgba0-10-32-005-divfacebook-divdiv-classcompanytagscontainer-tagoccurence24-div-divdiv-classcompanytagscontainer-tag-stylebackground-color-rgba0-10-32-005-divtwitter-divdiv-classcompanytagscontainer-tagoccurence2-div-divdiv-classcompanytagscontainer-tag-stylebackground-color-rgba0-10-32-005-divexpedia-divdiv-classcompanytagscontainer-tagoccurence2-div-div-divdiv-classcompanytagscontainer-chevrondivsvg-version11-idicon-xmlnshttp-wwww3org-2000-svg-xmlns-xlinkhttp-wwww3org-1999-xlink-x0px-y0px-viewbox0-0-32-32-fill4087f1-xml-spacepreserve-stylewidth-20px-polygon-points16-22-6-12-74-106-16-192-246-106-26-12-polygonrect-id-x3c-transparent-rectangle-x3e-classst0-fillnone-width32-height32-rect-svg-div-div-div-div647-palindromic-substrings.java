class Solution {
        public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];

        for(int ind = 0; ind < len; ind++){
            res[ind][ind] = true;
        }
        for(int ind = 0; ind < len-1; ind++){
            if(s.charAt(ind) == s.charAt(ind+1)){
                res[ind][ind+1] = true;
            }
        }
        
        for(int gap = 1; gap < len-1; gap++) {
            for(int ind = 0; ind < (len-gap-1); ind++){
                if(res[ind+1][ind+gap] && s.charAt(ind) == s.charAt(ind+gap+1)){
                    res[ind][ind+gap+1] = true;
                }
            }
        }

        int count =0;
        for(int wid =0; wid < len ; wid ++){
            for (int ind  = wid; ind < len; ind++){
                if(res[wid][ind]){
                   // System.out.println(res[wid][ind]);
                    count++;
                }
            }
        }

        return count;
    }
    
}