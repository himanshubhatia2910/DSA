class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> al = new ArrayList<>();
        
        int n = arr.length, m = arr[0].length;
        int rmin = 0, rmax = arr.length-1;
        int cmin = 0, cmax = arr[0].length-1;
        
        int count=0;
        while(count<n*m)
        {
            for(int col=cmin;col<=cmax && count< n*m;col++)
            {
                al.add(arr[rmin][col]);
                count++;
            }
            rmin++;
            for(int row=rmin;row<=rmax && count< n*m;row++)
            {
                al.add(arr[row][cmax]);
                count++;
            }
            cmax--;
            
             for(int col=cmax;col>=cmin && count< n*m;col--)
            {
                al.add(arr[rmax][col]);
                count++;
            }
            rmax--;
            
             for(int row=rmax;row>=rmin && count< n*m;row--)
            {
                al.add(arr[row][cmin]);
                count++;
            }
            cmin++; 
        }
        return al;
    }
}