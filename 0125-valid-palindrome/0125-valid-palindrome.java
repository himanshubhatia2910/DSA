class Solution {
    public boolean isPalindrome(String s) {
       String b = "";
        for(char c: s.toCharArray())
        {
            if(Character.isDigit(c) || Character.isLetter(c))
            {
                b+=c;
            }
        }
        b= b.toLowerCase();
        int start=0;
        int end= b.length()-1;
        while(start<=end)
        {
            if(b.charAt(start)!=b.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}