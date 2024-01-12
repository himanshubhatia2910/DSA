class Solution {
    Set<Character> map = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int f_len = len/2;
        int vowel_count = 0;

        for(int i=0 ; i<f_len ; i++){
            char c = s.charAt(i);
            if(map.contains(c)){
                vowel_count++;
            }
        }

        for(int i=f_len ; i<len ; i++){
            char c = s.charAt(i);
            if(map.contains(c)){
                vowel_count--;
            }
        }

        if(vowel_count != 0){
            return false;
        }

        return true;
    }
}