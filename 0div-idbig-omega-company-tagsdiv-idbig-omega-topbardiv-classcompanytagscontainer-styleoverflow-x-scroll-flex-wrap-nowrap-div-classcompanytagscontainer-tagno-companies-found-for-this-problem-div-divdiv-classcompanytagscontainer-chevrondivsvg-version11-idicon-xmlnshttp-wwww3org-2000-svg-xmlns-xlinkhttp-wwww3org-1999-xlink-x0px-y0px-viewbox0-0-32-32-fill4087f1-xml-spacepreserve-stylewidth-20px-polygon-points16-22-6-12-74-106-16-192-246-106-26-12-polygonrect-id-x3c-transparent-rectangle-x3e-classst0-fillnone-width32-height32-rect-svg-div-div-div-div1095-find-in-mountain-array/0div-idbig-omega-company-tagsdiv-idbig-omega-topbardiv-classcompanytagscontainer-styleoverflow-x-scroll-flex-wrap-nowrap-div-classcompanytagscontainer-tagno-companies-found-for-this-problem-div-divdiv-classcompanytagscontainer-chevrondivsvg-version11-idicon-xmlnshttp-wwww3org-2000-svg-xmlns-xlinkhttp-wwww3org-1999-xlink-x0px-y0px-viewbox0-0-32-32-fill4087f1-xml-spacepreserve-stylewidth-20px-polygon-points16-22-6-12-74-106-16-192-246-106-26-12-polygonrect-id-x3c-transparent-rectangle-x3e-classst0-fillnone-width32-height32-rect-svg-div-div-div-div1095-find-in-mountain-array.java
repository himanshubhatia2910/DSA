/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
     public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        //get the peek element from the array
        int peekIdx = findPeekIndex(1, n - 1, mountainArr);
        
        //Binary Search in the Increasing part of the array
        int increasingIdx = binarySearch(0, peekIdx, target, mountainArr, false);
        if(mountainArr.get(increasingIdx) == target) {
            return increasingIdx;   //target found
        }

        //Binary Search in Decreasing part of the array
        int decreasingIdx = binarySearch(peekIdx + 1, n - 1, target, mountainArr, true);
        if(mountainArr.get(decreasingIdx) == target) {
            return decreasingIdx;   //target found 
        }

        return -1;  //target not found
    }

    private int findPeekIndex(int left, int right, MountainArray arr) {
        int mid = 0;
        //Binary search
        while( left < right ) {
            mid = left + (right - left) / 2;

            if(arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1; //move to the right side aka increasing slope
            } else {
                right = mid;    //move to the left side aka decreasing slope
            }
        }

        return left; //peek element 
    }

    private int binarySearch(int left, int right, int target, MountainArray arr, boolean isReversed) {
        int mid = 0;

        //searching for increasing part
        if(!isReversed){    
            //Binary search
            while( left < right ) {
                mid = left + (right - left) / 2;
                int midValue = arr.get(mid);

                if(midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            //searching for decreasing part
        } else {    
            //Binary scarch
            while( left < right ) {
                mid = left + (right - left) / 2;
                int midValue = arr.get(mid);

                if(midValue > target) {
                    left = mid + 1;
                } else {
                    right = mid ;
                }
            }
        }

        return left; //peek element 
    }
}