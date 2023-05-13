class Solution {
    public int[] solution(int[] prices) {
        int[] time = new int[prices.length];
        for(int i=0; i<prices.length - 1; i++)
        {
            int fix = prices[i];
            for(int j=i+1; j<prices.length; j++)
            {
                time[i]++;
                
                if(fix > prices[j])
                {
                    break;
                }
            }
        }
        return time;
    }
}