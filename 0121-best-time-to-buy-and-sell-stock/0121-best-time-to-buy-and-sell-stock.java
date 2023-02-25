class Solution {
    public int maxProfit(int[] prices) {
        int least= Integer.MAX_VALUE;
        int current=0;
        int overall_profit=0;
        
        for(int i=0;i<prices.length;i++)
        {
            if(least>prices[i])
            {
                least=prices[i];
            }
            
            current= prices[i]-least;
            if(overall_profit<current)
            {
                overall_profit=current;
            }
        }
        return overall_profit;
    }
}