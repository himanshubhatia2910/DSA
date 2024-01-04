class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int answer=0;
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        
        for(int value: mp.keySet())
        {
            int val = mp.get(value);
            if(val==1) return -1;
            
            if(val%3==1 || val%3==2) answer+=(val/3)+1;
            else if(val%3==0) answer+=(val/3);
        }
        return answer;
    }
}