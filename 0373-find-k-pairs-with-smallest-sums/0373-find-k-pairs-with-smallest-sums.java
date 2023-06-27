class Solution {
   public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // Min heap.
        PriorityQueue<Data> queue = new PriorityQueue<>();
        // Add k elements.
        for (int i=0; i<k && i < nums1.length; i++) {
            // pair each element on nums1 with first element of nums2
            queue.add(new Data(i, 0, nums1[i] + nums2[0]));
        }

        List<List<Integer>> result = new ArrayList<>();
        // iterate k times.
        while (!queue.isEmpty() && k-- > 0) {
            Data data = queue.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[data.i]);
            pair.add(nums2[data.j]);
            // Add smallest from PriorityQueue into result array.
            result.add(pair);
            // add next element in queue.
            if (data.j + 1 < nums2.length) {
                queue.add(new Data(data.i, data.j+1, nums1[data.i] + nums2[data.j+1]));
            }
        }

        return result;
    }

    // Class to define structure of PriorityQueue data.
    class Data implements Comparable<Data> {
        // i is index of nums1 and j is index of nums2
        int i, j;
        int sum;
        Data(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        // sum is used for comparing two objects.
        public int compareTo(Data data) {
            return this.sum - data.sum;
        }
    }
}