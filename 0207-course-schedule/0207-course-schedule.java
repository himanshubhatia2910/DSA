class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int n = numCourses;
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList());

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int current = q.poll();
                count++;
                for (int neigh : graph.get(current)) {
                    if (--indegree[neigh] == 0)
                        q.add(neigh);
                }
            }
        }
        return count == n;
    }
}