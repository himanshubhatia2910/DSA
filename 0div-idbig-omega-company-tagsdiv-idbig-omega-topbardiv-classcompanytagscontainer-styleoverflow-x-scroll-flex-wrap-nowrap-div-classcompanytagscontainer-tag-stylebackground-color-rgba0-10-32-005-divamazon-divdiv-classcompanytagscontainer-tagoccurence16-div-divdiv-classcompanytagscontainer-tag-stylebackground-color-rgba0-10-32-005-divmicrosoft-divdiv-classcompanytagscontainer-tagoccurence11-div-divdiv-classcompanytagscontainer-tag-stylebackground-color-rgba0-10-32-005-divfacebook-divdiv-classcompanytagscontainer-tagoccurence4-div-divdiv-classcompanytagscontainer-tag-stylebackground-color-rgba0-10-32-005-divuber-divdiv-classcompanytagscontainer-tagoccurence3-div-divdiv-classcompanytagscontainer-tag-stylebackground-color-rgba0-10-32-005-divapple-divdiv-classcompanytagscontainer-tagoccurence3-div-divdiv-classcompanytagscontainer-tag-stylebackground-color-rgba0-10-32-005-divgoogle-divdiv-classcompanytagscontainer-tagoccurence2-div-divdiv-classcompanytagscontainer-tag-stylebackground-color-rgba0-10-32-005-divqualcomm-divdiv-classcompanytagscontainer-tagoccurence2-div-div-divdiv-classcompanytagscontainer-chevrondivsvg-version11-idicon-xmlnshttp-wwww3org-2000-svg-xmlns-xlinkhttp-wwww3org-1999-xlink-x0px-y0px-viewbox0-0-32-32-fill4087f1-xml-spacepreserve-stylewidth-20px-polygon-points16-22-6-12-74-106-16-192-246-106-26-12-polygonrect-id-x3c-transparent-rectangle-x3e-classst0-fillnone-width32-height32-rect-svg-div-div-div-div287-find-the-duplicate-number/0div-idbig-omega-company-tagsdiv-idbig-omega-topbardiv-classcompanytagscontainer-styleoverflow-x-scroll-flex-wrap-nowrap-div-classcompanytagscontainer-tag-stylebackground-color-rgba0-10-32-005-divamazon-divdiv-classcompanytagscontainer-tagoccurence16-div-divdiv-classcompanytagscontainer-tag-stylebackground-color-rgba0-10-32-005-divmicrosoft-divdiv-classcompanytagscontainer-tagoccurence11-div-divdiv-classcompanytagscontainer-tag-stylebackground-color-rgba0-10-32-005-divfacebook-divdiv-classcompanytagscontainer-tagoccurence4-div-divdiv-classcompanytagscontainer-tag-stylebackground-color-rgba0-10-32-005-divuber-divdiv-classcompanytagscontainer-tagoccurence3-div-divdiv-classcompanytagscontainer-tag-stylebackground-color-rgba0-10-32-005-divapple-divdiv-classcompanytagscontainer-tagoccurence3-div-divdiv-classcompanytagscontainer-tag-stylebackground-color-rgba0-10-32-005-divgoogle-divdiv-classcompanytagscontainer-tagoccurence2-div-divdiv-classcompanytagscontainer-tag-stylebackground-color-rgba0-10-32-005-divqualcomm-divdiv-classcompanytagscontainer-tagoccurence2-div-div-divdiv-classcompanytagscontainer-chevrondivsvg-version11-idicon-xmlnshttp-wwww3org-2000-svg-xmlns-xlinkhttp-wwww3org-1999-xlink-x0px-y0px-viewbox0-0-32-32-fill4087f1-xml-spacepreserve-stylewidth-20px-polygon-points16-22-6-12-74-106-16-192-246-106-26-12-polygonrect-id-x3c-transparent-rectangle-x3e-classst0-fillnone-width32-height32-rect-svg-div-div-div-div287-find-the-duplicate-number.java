class Solution {
   public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.get(i)==null)
            map.put(i,1);
            else
            map.put(i,map.get(i)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
          if(entry.getValue()>1)

            return entry.getKey();
        }
        return -1;
      
    }
}