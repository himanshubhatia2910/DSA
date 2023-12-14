
class Solution {
    static int NO_OF_CHARS=256;
    public boolean isAnagram(String s, String t) {
        int[] count = new int[NO_OF_CHARS];
        if(s.length()!=t.length())
        {
            return false;
        }
        
//         char[] str = s.toCharArray();
//         char[] str1 = t.toCharArray();
        
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }
        for(int j=0;j<NO_OF_CHARS;j++)
        {
            if(count[j]!=0) return false;
        }
        return true;
    }
}