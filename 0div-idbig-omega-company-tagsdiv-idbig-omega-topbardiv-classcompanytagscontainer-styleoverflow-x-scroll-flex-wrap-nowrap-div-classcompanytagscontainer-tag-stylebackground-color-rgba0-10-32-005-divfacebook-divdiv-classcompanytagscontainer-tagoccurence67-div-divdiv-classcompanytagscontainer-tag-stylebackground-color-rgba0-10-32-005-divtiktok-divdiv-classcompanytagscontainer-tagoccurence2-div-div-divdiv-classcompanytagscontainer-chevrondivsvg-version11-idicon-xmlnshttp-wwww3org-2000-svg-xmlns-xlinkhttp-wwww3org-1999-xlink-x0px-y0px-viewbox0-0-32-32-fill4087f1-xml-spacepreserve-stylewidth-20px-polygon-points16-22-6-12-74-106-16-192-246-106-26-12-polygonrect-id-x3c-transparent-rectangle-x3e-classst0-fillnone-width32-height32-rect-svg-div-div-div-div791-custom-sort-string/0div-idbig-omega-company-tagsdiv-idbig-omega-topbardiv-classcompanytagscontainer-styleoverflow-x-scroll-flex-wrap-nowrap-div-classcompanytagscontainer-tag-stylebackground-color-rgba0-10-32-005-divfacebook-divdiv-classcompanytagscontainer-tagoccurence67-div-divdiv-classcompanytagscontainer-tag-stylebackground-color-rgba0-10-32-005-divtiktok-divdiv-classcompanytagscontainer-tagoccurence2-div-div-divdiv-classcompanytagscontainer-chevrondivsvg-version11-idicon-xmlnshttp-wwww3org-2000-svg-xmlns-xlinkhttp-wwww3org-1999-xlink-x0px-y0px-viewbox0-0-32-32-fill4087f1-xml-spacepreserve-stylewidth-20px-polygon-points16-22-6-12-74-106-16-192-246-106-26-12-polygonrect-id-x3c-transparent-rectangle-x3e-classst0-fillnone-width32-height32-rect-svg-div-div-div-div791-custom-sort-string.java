class Solution {
    public String customSortString(String order, String s) {
        // Initialize an array to store the count of each character in 's'
        int cnt[] = new int[26];

        // Count the occurrences of each character in 's'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }

        // Initialize an empty string to store the sorted result
        String ans = "";

        // Process each character in the custom order
        for (char ch : order.toCharArray()) {
            int temp = cnt[ch - 'a'];

            // If the character exists in 's', append it to the result 'temp' times
            if (temp != 0) {
                for (int i = 0; i < temp; i++) {
                    ans = ans + ch;
                }
            }

            // Mark the count for this character as 0
            cnt[ch - 'a'] = 0;
        }

        // Process any remaining characters in 's' that are not in the custom order
        for (char ch : s.toCharArray()) {
            int temp = cnt[ch - 'a'];

            // If the character exists in 's', append it to the result 'temp' times
            if (temp != 0) {
                for (int i = 0; i < temp; i++) {
                    ans = ans + ch;
                }
            }

            // Mark the count for this character as 0
            cnt[ch - 'a'] = 0;
        }

        // Return the final sorted string
        return ans;
    }
}