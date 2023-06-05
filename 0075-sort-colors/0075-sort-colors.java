class Solution {
    public void sortColors(int[] arr) {
        int low=0,mid=0;
        int high=arr.length-1,temp=0;
        
        while(mid<=high)
        {
            switch(arr[mid])
            {
                case 0: temp=arr[low];
                        arr[low]=arr[mid];
                        arr[mid]=temp;
                        low++;
                        mid++;
                        break;
                case 1: mid++;
                        break;
                case 2: temp=arr[high];
                        arr[high]=arr[mid];
                        arr[mid]=temp;
                        high-=1;
                        break;
            }
        }
    }
}