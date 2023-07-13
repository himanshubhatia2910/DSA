class Solution {
     boolean isCycle(int node, int[][] graph, boolean[] visited, boolean[] check){
        if(visited[node]) return true;
        visited[node] = true;

        for(int i=0;i<graph[node].length;i++){
            if(check[graph[node][i]]) continue;
            if(isCycle(graph[node][i], graph, visited, check )) return true;
            check[graph[node][i]] = true;
        }
        visited[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] check   = new boolean[graph.length];
        Arrays.fill(visited, false);
        Arrays.fill(check, false);
        for(int i=0;i<graph.length;i++){
            if(check[i]) continue;
            isCycle(i, graph, visited, check);
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) res.add(i);
        }
        return res;
    }
}