class Solution {
    public int finalValueAfterOperations(String[] operations) {
      int x=0;
      for(String str:operations)
      {
          x+= str.charAt(1)=='+'? 1 : -1;
          
      }
        return x;
    }
}