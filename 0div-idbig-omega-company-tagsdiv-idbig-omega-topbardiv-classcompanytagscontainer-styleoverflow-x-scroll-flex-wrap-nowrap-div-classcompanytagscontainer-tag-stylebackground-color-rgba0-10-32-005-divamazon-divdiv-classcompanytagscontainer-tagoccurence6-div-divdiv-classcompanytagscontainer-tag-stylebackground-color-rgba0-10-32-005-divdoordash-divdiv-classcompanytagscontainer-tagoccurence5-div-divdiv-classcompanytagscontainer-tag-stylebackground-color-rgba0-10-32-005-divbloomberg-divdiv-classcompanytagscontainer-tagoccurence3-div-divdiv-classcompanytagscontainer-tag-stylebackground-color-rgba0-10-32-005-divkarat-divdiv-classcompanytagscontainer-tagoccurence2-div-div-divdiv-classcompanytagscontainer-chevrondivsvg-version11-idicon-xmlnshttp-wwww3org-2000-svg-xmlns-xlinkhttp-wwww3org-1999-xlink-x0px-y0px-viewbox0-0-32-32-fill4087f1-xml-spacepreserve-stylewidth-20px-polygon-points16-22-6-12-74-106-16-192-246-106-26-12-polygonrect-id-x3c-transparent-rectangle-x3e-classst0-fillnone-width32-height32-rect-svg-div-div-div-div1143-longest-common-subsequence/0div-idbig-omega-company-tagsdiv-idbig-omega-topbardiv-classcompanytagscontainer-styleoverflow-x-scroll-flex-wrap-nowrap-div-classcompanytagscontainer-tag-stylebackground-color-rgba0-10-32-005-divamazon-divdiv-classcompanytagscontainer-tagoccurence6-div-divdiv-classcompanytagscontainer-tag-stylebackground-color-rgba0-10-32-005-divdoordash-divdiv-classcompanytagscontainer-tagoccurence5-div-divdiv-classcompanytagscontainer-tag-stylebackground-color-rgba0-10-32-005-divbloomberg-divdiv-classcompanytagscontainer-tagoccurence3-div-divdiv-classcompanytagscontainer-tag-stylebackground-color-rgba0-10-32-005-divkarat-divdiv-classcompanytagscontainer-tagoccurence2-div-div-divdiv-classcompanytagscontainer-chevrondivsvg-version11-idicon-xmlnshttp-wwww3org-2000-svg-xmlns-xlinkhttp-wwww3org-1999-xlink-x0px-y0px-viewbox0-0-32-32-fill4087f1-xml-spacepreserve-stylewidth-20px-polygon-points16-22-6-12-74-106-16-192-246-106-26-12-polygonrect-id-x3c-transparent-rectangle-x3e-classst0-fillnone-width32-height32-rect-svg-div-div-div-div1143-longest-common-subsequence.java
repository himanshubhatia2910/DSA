class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //return findMem(text1, text2);
        return findTab(text1, text2);
    }
    public int findOpt(String text1, String text2){
        int[] next = new int[text2.length()+1];

        for(int ind1 = text1.length()-1; ind1>=0; ind1--){
            int[] curr = new int[text2.length()+1];
            for(int ind2 = text2.length()-1; ind2>=0; ind2--){
                //same
                int same = 0;
                if(text1.charAt(ind1) == text2.charAt(ind2))
                same = 1 + next[ind2 + 1];

                //different
                int diff1 = 0;
                int diff2 = 0;

                diff1 = curr[ind2+1];
                diff2 = next[ind2];

                curr[ind2] = Math.max(same, Math.max(diff1, diff2));
            }
        }
        return next[0];
    }
    public int findTab(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int ind1 = text1.length()-1; ind1>=0; ind1--){
            for(int ind2 = text2.length()-1; ind2>=0; ind2--){
                //same
                int same = 0;
                if(text1.charAt(ind1) == text2.charAt(ind2))
                same = 1 + dp[ind1 + 1][ind2 + 1];

                //different
                int diff1 = 0;
                int diff2 = 0;

                diff1 = dp[ind1][ind2+1];
                diff2 = dp[ind1+1][ind2];

                dp[ind1][ind2] = Math.max(same, Math.max(diff1, diff2));
            }
        }
        return dp[0][0];
    }
    public int findMem(String text1, String text2){
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] ar: dp){
            Arrays.fill(ar, -1);
        }
        return findMax(text1, text2, 0, 0, dp);
    }
    public int findMax(String text1, String text2, int ind1, int ind2, int[][] dp){
        if(ind1>=text1.length() || ind2>=text2.length())
        return 0;

        if(dp[ind1][ind2]!=-1)
        return dp[ind1][ind2];

        //same
        int same = 0;
        if(text1.charAt(ind1) == text2.charAt(ind2))
        same = 1 + findMax(text1, text2, ind1 + 1, ind2 + 1, dp);

        //different
        int diff1 = 0;
        int diff2 = 0;

        diff1 = findMax(text1, text2, ind1, ind2+1, dp);
        diff2 = findMax(text1, text2, ind1+1, ind2, dp);

        return dp[ind1][ind2] = Math.max(same, Math.max(diff1, diff2));

    }
}