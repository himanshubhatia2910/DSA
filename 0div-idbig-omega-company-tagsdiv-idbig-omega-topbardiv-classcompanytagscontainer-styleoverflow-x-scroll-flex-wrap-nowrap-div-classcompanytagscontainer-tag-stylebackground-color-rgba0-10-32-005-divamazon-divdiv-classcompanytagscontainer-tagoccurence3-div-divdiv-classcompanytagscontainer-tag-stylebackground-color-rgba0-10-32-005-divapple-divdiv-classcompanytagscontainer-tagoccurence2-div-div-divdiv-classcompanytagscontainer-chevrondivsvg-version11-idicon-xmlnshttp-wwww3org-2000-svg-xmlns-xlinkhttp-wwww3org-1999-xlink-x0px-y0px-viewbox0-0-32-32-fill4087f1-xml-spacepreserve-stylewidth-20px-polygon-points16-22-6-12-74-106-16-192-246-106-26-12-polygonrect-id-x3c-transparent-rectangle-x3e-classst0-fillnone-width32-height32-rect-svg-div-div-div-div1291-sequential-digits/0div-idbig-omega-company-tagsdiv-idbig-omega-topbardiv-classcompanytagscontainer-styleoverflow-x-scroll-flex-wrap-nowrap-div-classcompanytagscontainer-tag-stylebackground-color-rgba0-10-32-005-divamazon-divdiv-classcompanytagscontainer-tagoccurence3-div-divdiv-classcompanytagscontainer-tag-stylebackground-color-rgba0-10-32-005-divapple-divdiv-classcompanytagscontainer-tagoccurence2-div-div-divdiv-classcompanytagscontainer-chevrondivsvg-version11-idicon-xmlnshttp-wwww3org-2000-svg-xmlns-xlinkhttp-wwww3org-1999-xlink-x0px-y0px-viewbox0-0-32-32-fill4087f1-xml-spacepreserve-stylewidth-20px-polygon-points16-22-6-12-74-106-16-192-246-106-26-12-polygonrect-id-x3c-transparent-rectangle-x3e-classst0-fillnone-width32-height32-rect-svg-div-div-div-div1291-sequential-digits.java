class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> li  =new ArrayList<>();
        int[] arr = {111,1111,11111,111111,1111111,11111111,111111111,1111111111};
        int[] arr2= {123,1234,12345,123456,1234567,12345678,123456789};
        int num1=11;
        int i=12,j=0;
        while(i<=high){
            int rem=i%10;
            if(rem==0){
                break;
            }
            if(rem==9){
                if(low<=i && i<=high)li.add(i);
                i=arr2[j];
                num1=arr[j];
                j++;
            }
            if(low<=i && i<=high)
            {
                li.add(i);
            }
            i+=num1;
        }
        return li;
    }
}