class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int [][] index=new int[][]{{-1,-1},{-1,0},{-1,1},
                                {0,-1},{0,1},
                                {1,-1},{1,0},{1,1}};
        Queue<int []> q=new LinkedList<>();
        q.add(new int[]{0,0});
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int [] cell=q.poll();
                if(cell[0]==n-1 && cell[1]==n-1) return ans;
                for(int [] ind:index){
                    int row=cell[0]+ind[0];
                    int col=cell[1]+ind[1];
                    if(row>=0 && row<n && col>=0 && col<n && grid[row][col]!=1){
                        grid[row][col]=1;
                        q.add(new int[]{row,col});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}