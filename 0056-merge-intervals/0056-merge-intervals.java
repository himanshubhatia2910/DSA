class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        
        for(int i=1;i<intervals.length;i++)
        {
            if(stack.peek()[1]>=intervals[i][0])
            {
                stack.peek()[1]= Math.max(stack.peek()[1],intervals[i][1]);
            }
            else
            {
                stack.push(intervals[i]);
            }
        }
        int[][] ans = new int[stack.size()][2];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i][0]=stack.peek()[0];
            ans[i][1]= stack.peek()[1];
            stack.pop();
        }
        return ans;
    }
}