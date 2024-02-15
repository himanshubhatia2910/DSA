class Solution {
   public int[] rearrangeArray(int[] nums){
        List<Integer> pos_nums=new ArrayList<>();
        List<Integer> neg_nums=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i:nums){
            if(i>=0){
                pos_nums.add(i);
            }else {
                neg_nums.add(i);
            }
        }
        int pos_nums_index=0;
        int neg_nums_index=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                ans.add(pos_nums.get(pos_nums_index));
                pos_nums_index++;
            }else{
                ans.add(neg_nums.get(neg_nums_index));
                neg_nums_index++;
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}