class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // going to use min heap, so that whenever we poll, should get the min element
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<heights.length - 1 ;i++){
            int levelDistance = heights[i+1] - heights[i];
            // levelDistance > 0, means we have to make a jump
            if(levelDistance > 0){
                // add this value into min heap
                pq.add(levelDistance);
            }

            // when heap size inceases to ladders count, it means 
            // we are in a situation where we can not guarantee that we can make a jump or not
            // to check this get the smaller element from heap and check either that can be handle
            // with breaks or not, if it can then go ahead or else drop the situation
            if(pq.size() > ladders){
                bricks = bricks - pq.poll();
            }

            // if bricks < 0, it means situation can not be handled with bricks
            if(bricks < 0){
                return i;
            }
        }
        // when you reach to the end of the array, it means all building can be cover,
        // so return the last index
    return heights.length - 1;
    }
}