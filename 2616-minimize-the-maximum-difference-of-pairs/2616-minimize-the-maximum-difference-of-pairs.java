class Solution {
   public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length-1]-nums[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            int count = 0;
            for(int i=1; i<nums.length; i++){
                if(nums[i]-nums[i-1] <= mid){
                    count++;
                    i++;
                }
                if(count > p) break;
            }
            if(count < p){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}