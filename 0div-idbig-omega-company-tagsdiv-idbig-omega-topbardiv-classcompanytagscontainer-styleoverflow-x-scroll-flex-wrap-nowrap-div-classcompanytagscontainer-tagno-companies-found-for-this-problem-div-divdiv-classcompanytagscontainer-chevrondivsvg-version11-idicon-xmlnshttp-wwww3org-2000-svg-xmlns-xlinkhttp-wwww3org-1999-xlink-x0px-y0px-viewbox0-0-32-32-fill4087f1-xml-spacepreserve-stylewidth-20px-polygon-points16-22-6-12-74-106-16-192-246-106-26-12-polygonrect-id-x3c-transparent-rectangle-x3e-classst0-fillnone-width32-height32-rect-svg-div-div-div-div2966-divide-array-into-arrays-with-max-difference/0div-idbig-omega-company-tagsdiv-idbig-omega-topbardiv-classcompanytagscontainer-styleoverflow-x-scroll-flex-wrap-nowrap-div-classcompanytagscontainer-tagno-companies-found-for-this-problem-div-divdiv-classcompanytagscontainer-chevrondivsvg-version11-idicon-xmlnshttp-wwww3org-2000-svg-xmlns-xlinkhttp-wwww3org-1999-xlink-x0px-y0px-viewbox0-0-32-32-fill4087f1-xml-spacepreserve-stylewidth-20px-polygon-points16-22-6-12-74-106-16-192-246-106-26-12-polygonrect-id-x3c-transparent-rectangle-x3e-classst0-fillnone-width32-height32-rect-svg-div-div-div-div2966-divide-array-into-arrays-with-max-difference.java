class Solution {
   public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] arr1 = new int[nums.length/3][3];
        int c=0;
        for(int i=0;i<nums.length/3;i++){
            int[] arr = new int[3];
            for(int j=0;j<3;j++){
                arr1[i][j] = nums[c];
                c++;
                if(j==2 && (!(arr1[i][2] - arr1[i][1] <= k) || !(arr1[i][2] - arr1[i][0] <= k))){
                    return new int[][]{};
                }
            }
        }
        return arr1;
    }
}