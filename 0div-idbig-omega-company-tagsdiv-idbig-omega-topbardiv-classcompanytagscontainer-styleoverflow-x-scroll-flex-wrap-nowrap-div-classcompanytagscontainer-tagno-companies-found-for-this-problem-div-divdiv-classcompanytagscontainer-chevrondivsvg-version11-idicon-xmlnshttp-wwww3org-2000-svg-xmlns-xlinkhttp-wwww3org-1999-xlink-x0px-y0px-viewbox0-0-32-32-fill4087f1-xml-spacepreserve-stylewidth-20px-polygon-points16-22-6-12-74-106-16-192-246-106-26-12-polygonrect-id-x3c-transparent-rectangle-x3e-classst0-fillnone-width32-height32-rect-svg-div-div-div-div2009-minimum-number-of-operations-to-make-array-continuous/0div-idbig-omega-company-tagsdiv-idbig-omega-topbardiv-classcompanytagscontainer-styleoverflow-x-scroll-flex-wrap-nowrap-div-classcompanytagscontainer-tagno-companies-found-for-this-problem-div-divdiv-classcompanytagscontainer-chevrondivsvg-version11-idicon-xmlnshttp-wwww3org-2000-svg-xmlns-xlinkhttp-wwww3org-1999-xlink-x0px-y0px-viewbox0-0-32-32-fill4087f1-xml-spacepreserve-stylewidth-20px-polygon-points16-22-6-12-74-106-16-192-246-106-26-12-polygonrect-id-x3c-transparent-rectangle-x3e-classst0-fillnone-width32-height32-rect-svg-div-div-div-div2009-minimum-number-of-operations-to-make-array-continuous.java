class Solution {
    public int minOperations(int[] nums) {
    Arrays.sort(nums);
    int minOperations = Integer.MAX_VALUE;
    int j = 1; 
    int duplicateCount = 0;
    int[] duplicateArray = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
        while (j < nums.length && nums[j] <= nums[i] + nums.length - 1) {
         
            if (nums[j] == nums[j - 1]) {
                duplicateCount++;
            }
            duplicateArray[j] = duplicateCount;
            j++;
        }
       
        minOperations = Math.min(minOperations, i + (nums.length - j) + duplicateCount - duplicateArray[i]);
    }

    return minOperations;
}

}