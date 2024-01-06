class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Schedule[] schedules = new Schedule[startTime.length];
        for (int i = 0 ; i < startTime.length ; i++) {
            schedules[i] = new Schedule(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(schedules, (a, b) -> a.startT - b.startT);
        dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        return dfs(0, schedules);
    }

    int[] dp;

    // we have two options, choosing and not choosing
    private int dfs(int index, Schedule[] schedules) {
        if (index >= schedules.length) return 0;
        if (dp[index] != -1) return dp[index];
        int res = Integer.MIN_VALUE;
        // not choosing
        res = Math.max(res, dfs(index + 1, schedules));
        // binary search to find next valid index if we choose
        int nextValid = index + 1;
        int lo = nextValid - 1;
        int hi = schedules.length;
        while (lo + 1 != hi) {
            int mid = lo + (hi - lo) / 2;
            if (schedules[mid].startT >= schedules[index].endT) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        nextValid = hi;
        // choosing
        res = Math.max(res, dfs(nextValid, schedules) + schedules[index].profit);
        dp[index] = res;
        return res;
    }

    class Schedule {
        int startT;
        int endT;
        int profit;
        public Schedule (int startT, int endT, int profit) {
            this.startT = startT;
            this.endT = endT;
            this.profit = profit;
        }
    }
}