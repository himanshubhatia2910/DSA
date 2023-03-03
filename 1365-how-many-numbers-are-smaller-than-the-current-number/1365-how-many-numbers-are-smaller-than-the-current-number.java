class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int arr[]= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=list.indexOf(nums[i]);
        }
        return arr;
    }
}