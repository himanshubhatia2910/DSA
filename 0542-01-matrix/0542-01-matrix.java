class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if(mat[0][0] != 0) mat[0][0] = m+n;
        //handle horizontal base line 
        for(int j = 1;j < m; j++){
            if(mat[0][j]!=0) mat[0][j] = mat[0][j-1]+1;
        }
        //handle vertical base line 
        for(int i = 1;i < n; i++){
            if(mat[i][0] != 0) mat[i][0] = mat[i-1][0]+1;
        }
        //check uper side of i and j and fill the matrix 
        for(int i = 1;i < n; i++){
            for(int j = 1;j < m; j++){
                // take min of left and up with addition of our cell dist
                if(mat[i][j] != 0) mat[i][j] = Math.min(mat[i-1][j],mat[i][j-1])+1;
            }
        }
        //handle horizontal base line 
        for(int j = m-2;j >= 0; j--){
            if(mat[n-1][j] != 0)  mat[n-1][j] = Math.min(mat[n-1][j],mat[n-1][j+1]+1);
        }
        //handle  vertical base line
        for(int i = n-2;i >= 0; i--){
            if(mat[i][m-1] != 0) mat[i][m-1] = Math.min(mat[i][m-1],mat[i+1][m-1]+1);
        }
        //reverse filling of matrix considering lower part of i and j 
        for(int i = n-2;i >= 0; i--){
            for(int j = m-2;j >= 0; j--){
                //as we have already checked up and left 
                //now compare  the older value with new down and right values 
                //with addition of 1 -> count our own distance and take min 
                if(mat[i][j] != 0) mat[i][j] = Math.min(mat[i][j],Math.min(mat[i+1][j], mat[i][j+1])+1);
            }
        }
        return mat;
    }
}