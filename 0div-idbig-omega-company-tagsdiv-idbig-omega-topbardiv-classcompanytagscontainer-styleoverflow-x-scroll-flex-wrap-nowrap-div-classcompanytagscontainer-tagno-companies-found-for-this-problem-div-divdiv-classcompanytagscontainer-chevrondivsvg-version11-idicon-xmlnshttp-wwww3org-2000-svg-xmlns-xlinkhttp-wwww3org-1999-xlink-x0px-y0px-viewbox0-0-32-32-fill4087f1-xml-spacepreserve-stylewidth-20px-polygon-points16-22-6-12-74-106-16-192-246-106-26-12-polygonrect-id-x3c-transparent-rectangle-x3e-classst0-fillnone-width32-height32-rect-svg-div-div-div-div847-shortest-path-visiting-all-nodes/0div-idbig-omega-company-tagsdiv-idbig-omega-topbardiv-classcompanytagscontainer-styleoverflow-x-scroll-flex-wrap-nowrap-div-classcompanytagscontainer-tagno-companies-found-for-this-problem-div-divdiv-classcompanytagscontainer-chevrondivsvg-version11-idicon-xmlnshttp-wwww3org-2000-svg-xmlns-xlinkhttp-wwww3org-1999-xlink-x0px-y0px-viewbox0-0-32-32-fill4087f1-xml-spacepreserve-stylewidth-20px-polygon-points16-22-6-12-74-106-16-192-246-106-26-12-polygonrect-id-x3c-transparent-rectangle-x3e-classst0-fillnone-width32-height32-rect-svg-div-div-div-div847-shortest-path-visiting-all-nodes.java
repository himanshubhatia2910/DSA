class Solution {
    record PathNode(int currentNode, int nodesMask){}; 

    public int shortestPathLength(int[][] graph) {    

        int N = graph.length;    

        List<Integer> sources = getNodesWithLeastDegree(graph); //we need to start BFS from nodes which has less degree, because shorted path never starts from the node which has more degree.

        Queue<PathNode> queue = new LinkedList<>();

        for(int source : sources)
            queue.add(new PathNode(source, setBit(0,source)));

        Set<PathNode> visited = new HashSet<>(); 

        int pathLength = 0; 

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int currentMask = queue.peek().nodesMask; 
                int currentNode = queue.poll().currentNode; 
                if(Integer.bitCount(currentMask) == N)
                    return pathLength;
                
                for(int adjNode : graph[currentNode]){
                    int nextMask = setBit(currentMask, adjNode); 
                    if(Integer.bitCount(nextMask) == N)
                        return pathLength+1; 

                    PathNode pathNode = new PathNode(adjNode,nextMask); 
                    if(!visited.contains(pathNode)){
                        queue.add(new PathNode(adjNode, setBit(currentMask, adjNode)));
                        visited.add(pathNode);
                    }
                }
            }
            pathLength++;
        }
        return pathLength; 
    }

    int setBit(int mask, int position){
        return mask | (1 << position);
    }

    List<Integer> getNodesWithLeastDegree(int[][] graph){
        int N = graph.length; 
        List<Integer> sources = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int[] degree = new int[N];
        for(int i=0; i < N; i++)
            degree[i] = graph[i].length; 
        for(int i=0; i < N; i++){
            pq.add(new int[]{i, degree[i]});
        }

        if(pq.isEmpty())
            return sources; 
        int leastDegree = pq.peek()[1];
        while(!pq.isEmpty() && pq.peek()[1] == leastDegree)
            sources.add(pq.poll()[0]);
        return sources; 
    }

}
