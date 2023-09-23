class Solution {
    public int longestStrChain(String[] words) {
         Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> memo = new HashMap<>();

        int maxChain = 0;
        for (String word : words) {
            maxChain = Math.max(maxChain, dfs(word, wordSet, memo));
        }

        return maxChain;
    }

    private int dfs(String word, Set<String> wordSet, Map<String, Integer> memo) {
        if (!wordSet.contains(word)) {
            return 0;
        }

        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        int maxChain = 1;
        for (int i = 0; i < word.length(); i++) {
            String nextWord = word.substring(0, i) + word.substring(i + 1);
            maxChain = Math.max(maxChain, 1 + dfs(nextWord, wordSet, memo));
        }

        memo.put(word, maxChain);
        return maxChain;
    }
}