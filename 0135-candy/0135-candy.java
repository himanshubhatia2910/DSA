class Solution {
     public int candy(int[] ratings) {
        int result =0;
        int[] LToR = new int[ratings.length];
        for(int i=0; i<ratings.length; i++){
          LToR[i]=1;
        }
        int[] RToL = new int[ratings.length];
        for(int i=0; i<ratings.length; i++){
          RToL[i]=1;
        }
        for(int i=0; i<ratings.length-1;i++){
          if(ratings[i]<ratings[i+1]){
            LToR[i+1] =LToR[i]+1;
          }
        }
        for(int i=ratings.length-1; i>0; i--){
          if(ratings[i] < ratings[i - 1]) { 
              RToL[i - 1] = RToL[i] + 1; 
          }
        }
        for(int i = 0; i < ratings.length; i++) { 
            result += Math.max(LToR[i], RToL[i]);
        }
        return result;
    }
}