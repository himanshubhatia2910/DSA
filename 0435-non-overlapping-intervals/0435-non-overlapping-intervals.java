class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int count = 0;
        int n = intervals.length;
        int k = Integer.MIN_VALUE;
        int i = 0;

        while(i < n){
            if(intervals[i][0] >= k){
                k = intervals[i][1];
            }else{
                count++;
            }

            i++;
        }

        return count;
    }
}