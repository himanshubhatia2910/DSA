class Solution {
   public int numberOfBeams(String[] bank) {
        int res=0;
        int  prev=0; 

        for(String s : bank){
            int curr = countOnes(s);
            if(curr==0)
            continue;

             res += (curr * prev);
             prev = curr;
        }

        return res;
    }

    public static int countOnes(String s){
        int count =0; 
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1')
            count++;
        }

        return count;
    }
}