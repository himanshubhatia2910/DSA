class Solution {
     public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        int l=0, r=costs.length-1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] > b[0])
                    return 1;
                else if (a[0] < b[0])
                    return -1;
                return a[1] - b[1];
            }
        );
        while (candidates>0) {
            if (l>r)
                break;
            pq.add(new int[]{costs[l], l++});
            if (l>r)
                break;
            pq.add(new int[]{costs[r], r--});
            candidates--;
        }
        while (k>0) {
            int[] top = pq.poll();
                ans += top[0];
            //System.out.println(top[0]+","+top[1]+"|"+l+","+r);
            if(l<=r) {
                if (top[1] > r) 
                    pq.add(new int[]{costs[r], r--});
                else
                    pq.add(new int[]{costs[l], l++});
            }
            k--;
        }
        return ans;
    }
}