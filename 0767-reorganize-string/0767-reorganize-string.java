class Solution {
    public String reorganizeString(String s) {

        // freq of chars
        int[] charCounts = new int[26];
        for (char c : s.toCharArray())
            charCounts[c - 'a']++;

        // max freq letter
        int maxCount = 0, letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }

        // failing condition
        if (maxCount > (s.length() + 1) / 2)
            return "";

        char[] ans = new char[s.length()];
        int index = 0;

        // place the most freq letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length())
                    index = 1;
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}