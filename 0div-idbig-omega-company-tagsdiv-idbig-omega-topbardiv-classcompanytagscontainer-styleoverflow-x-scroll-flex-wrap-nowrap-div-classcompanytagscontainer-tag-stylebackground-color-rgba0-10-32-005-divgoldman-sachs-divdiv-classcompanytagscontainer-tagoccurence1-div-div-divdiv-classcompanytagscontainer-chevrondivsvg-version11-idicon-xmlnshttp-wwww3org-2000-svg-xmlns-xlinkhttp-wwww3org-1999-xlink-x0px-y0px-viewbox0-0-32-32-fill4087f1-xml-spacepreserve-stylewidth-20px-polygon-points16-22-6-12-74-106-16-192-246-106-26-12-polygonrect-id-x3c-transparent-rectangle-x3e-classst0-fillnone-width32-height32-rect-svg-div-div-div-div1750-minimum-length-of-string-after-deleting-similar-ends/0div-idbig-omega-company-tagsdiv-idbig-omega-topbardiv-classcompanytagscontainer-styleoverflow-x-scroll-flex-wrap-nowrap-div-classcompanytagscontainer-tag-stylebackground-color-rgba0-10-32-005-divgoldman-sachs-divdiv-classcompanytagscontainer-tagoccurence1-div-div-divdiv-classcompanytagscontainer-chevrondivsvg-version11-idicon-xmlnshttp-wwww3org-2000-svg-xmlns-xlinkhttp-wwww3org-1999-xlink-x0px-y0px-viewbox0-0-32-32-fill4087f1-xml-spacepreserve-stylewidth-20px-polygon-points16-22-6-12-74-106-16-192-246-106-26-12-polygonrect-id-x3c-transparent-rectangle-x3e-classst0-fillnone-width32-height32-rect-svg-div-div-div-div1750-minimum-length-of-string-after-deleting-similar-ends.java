class Solution {
 public int minimumLength(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        int count=0;
        while(i<j){
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            if(ch1==ch2){
                while(i<j&&ch1==s.charAt(j)){
                    j--;
                    count++;
                }
                while(i<=j&&s.charAt(i)==ch2){
                    i++;
                    count++;
                }
            }else{
                break;
            }
        }
        return n-count;
    }
}