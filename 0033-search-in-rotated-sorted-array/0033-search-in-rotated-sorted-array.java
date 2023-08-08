class Solution {
    public int search(int[] nums, int target) {
        int si=0;
        int ei=nums.length-1;
        int ans=rsa(nums,target,si,ei);
        return ans;
    }

    public int rsa(int[] arr,int tar,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid = si+(ei-si)/2;
        if(arr[mid]==tar){
            return mid;
        }
        if(arr[si]<=arr[mid]){
            if(arr[si]<=tar && tar<=arr[mid]){
                return rsa(arr,tar,si,mid-1);
            }else{
                return rsa(arr,tar,mid+1,ei);
        }
        }else{
            if(arr[mid]<=tar && tar<=arr[ei]){
                return rsa(arr,tar,mid+1,ei);
            }else{
                return rsa(arr,tar,si,mid-1);
            }
        }
    }
}