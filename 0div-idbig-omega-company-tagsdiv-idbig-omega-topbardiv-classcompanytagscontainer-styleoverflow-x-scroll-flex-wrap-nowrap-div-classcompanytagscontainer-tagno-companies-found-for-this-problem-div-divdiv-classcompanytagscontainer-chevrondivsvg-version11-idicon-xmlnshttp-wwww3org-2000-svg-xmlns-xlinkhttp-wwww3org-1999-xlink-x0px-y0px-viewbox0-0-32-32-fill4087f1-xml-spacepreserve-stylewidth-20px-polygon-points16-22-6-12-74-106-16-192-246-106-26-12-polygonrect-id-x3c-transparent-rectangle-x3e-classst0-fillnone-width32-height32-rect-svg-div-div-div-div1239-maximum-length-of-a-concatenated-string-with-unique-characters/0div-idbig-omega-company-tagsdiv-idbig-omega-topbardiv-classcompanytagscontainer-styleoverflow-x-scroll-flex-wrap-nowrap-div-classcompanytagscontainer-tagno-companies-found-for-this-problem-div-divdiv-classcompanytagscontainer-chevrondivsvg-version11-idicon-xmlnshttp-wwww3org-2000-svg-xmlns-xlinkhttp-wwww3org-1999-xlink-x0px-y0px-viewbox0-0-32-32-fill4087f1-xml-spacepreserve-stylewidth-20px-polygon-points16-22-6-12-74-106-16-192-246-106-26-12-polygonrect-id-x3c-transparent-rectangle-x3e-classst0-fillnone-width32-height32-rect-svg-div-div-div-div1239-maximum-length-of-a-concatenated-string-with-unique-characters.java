class Solution {
    public int maxLength(List<String> arr)
     {
        return backtrack(arr, 0, "");
    }
    private int backtrack(List<String> arr, int index, String current) {
        if (index == arr.size()) {
         
            if (hasUniqueCharacters(current)) {
                return current.length();
            }
            return 0;
        }
        int maxLength = backtrack(arr, index + 1, current);
        if (hasUniqueCharacters(current + arr.get(index))) {
            int newLength = backtrack(arr, index + 1, current + arr.get(index));
            maxLength = Math.max(maxLength, newLength);
        }
        return maxLength;
    }
    private boolean hasUniqueCharacters(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}