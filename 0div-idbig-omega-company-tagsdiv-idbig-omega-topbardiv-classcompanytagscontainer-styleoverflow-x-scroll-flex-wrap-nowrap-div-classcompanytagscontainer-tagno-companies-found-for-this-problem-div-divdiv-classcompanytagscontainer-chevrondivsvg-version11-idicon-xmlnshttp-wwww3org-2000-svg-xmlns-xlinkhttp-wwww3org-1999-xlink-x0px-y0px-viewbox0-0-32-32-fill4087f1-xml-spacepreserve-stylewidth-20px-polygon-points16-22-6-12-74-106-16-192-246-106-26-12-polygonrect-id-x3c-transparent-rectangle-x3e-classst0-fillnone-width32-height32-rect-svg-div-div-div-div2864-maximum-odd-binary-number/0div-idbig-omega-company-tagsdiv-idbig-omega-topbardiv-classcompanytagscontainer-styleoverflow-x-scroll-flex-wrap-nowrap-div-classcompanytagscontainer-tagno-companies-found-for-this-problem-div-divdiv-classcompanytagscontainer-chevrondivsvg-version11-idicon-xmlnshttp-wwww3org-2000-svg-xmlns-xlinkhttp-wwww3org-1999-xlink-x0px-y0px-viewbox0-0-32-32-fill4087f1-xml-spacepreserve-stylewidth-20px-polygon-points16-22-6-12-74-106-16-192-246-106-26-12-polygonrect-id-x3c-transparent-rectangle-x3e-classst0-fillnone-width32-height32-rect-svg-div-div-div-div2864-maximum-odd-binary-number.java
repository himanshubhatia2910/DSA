class Solution {
    public String maximumOddBinaryNumber(String s) {
         int countone=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                countone++;
            }
        }
        int countzero=s.length()-countone;
        countone--;
        String ans="";
        while(countone>0){
            ans+='1';
            countone--;
        }
        while(countzero>0){
            ans+='0';
            countzero--;
        }
        ans+='1';
        return ans;
    }
}