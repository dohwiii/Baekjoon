class Solution {
    public int[] solution(int[] prices) {
        int[] time = new int[prices.length];
        for(int i=0; i<prices.length - 1; i++)
        {
            int fix = prices[i];
            int count = 1;
            for(int j=i+1; j<prices.length; j++)
            {
                if(fix > prices[j])
                {
                    time[i] = count;
                    break;
                }
                else if(fix <= prices[j])
                {
                    time[i]++;
                    count++;
                }
            }
        }
        return time;
    }
}