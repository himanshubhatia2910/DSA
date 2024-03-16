class Solution {
     public int findMaxLength(int[] nums) {
        int arr[] = new int[nums.length+1];
        int count = 0;
        arr[0] = 0;
        for(int i = 1;i < arr.length;i++) {
            if(nums[i-1] == 1) {
                count++;
                arr[i] = count;
            }
            else {
                count--;
                arr[i] = count;
            }
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++) {
            if(map.containsKey(arr[i])) {
                ans = Math.max(ans, i - map.get(arr[i]));
            }
            else {
                map.put(arr[i], i);
            }
        }
        return ans;
    }
}