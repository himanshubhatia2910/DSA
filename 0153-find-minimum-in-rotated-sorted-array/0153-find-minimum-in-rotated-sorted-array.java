class Solution {
    public int findMin(int[] arr) {
       int left=0,right = arr.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]<arr[right])
                right = mid;
            else left = mid+1;
        }
        return arr[right];
    }
}