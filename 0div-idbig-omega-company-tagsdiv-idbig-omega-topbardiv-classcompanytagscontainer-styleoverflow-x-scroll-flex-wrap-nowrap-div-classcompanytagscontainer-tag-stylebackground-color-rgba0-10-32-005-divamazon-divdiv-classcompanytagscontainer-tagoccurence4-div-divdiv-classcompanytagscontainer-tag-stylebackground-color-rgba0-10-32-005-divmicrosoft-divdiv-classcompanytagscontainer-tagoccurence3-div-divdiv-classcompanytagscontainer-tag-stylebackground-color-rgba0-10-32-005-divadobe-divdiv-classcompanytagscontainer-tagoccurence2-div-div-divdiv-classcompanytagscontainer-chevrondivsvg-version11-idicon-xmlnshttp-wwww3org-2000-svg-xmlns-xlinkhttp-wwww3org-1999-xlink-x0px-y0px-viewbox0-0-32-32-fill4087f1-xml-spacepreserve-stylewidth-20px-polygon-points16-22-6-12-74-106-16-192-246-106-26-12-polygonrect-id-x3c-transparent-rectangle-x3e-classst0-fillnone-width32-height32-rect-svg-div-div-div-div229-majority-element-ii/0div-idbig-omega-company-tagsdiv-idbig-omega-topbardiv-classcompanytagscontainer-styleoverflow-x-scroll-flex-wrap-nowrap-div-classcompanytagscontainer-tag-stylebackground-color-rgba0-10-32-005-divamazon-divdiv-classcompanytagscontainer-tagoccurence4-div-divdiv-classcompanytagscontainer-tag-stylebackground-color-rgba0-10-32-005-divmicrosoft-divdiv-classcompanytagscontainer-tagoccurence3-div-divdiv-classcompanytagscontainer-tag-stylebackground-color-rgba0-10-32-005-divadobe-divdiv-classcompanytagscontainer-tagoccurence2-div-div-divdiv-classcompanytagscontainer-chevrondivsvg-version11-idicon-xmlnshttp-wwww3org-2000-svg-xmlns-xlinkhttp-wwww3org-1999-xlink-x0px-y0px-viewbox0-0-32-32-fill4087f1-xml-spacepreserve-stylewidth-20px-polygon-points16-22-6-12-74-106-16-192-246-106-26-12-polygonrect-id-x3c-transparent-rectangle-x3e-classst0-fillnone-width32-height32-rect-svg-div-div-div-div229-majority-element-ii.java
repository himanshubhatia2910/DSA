class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=0;j<n;j++){
                //checking if same is element is not compared 
                if(i!=j){
                    if(nums[i]==nums[j]){
                        count=count+1;
                    }
                }
            }
            //given condition
            if(count>(n/3)){
                hs.add(nums[i]);
                nums[i]=-1;
            }
        }
        //adding elements from hashset to arraylist
        ArrayList<Integer>al=new ArrayList<>(hs);
        return al; 
    }
}