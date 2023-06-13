class Solution {
    public int equalPairs(int[][] grid) {
         String[] strArr1 = new String[grid.length];
        String[] strArr2 = new String[grid.length];
        for(int i=0;i<grid.length;i++){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int j=0;j<grid[0].length;j++) {
                sb1.append(grid[i][j]).append("#");
                sb2.append(grid[j][i]).append("#");
            }
            strArr1[i] = sb1.toString();
            strArr2[i] = sb2.toString();
        }
    
        int count = 0;
        for(int i=0;i<strArr1.length;i++){
            for(int j=0;j<strArr2.length;j++){
                if(strArr1[i].equals(strArr2[j])){
                    count++;
                }
            }
        }
        return count;
    }
}