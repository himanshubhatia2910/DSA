class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i = 0;
        int j = s.length()-1;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (i < j) {
            sb1.append(s.charAt(i++));
            sb2.insert(0, s.charAt(j--));
            if (sb1.toString().equals(sb2.toString())) {
                String aux = s.substring(i, j+1);
                if (aux.isEmpty() || aux.split(sb1.toString()).length == 0)
                    return true;
            }
        }
        return false;
    }
}