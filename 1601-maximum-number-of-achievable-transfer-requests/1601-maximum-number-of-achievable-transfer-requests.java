class Solution {
      public int maximumRequests(int n, int[][] requests) {
        return dfs(new int[n], requests, 0, 0);
    }
    private int dfs(int delta[], int[][] requests, int k, int m) {
        if (k == requests.length) {
            for (int d : delta) if (d != 0) return 0;
            return m;
        }
        int req[] = requests[k++], from = req[0], to = req[1];
        delta[from]--; delta[to]++;
        int go = dfs(delta, requests, k, m + 1);
        if (from == to) return go; // optimization
        delta[from]++; delta[to]--;
        int stay = dfs(delta, requests, k, m);
        return Math.max(stay, go);
    }
}