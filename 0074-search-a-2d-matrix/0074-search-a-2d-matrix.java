class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length; 
        int cols = matrix[0].length;
        for(int i=start; i<end; i++){
            if(matrix[i][0]<=target && matrix[i][cols-1]>=target){
                return findCol(i, cols, matrix, target);
            }
        }
        return false;
    }
        public boolean findCol(int i, int cols, int matrix[][], int target){ 
            int start = 0, end = cols-1;
            while(start<=end){
                int mid = (start + end)/2;
                if(matrix[i][mid]==target){
                    return true;
                }
                else if(matrix[i][mid]>target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            return false;
        }

}