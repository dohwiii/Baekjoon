class Solution {
    public int solution(int n) {
        if(n == 1) {
            return 1;
        }
        int answer = 0;
        int s = 1, e = 2;
        //누적합
        int[] sum = new int[n + 1];
        for(int i=1; i<=n; i++) {
            sum[i] = i + sum[i-1];
        }
        
        while(e <= n) {
            int total = sum[e] - sum[s - 1];
            
            if(total <= n) {
                if(total == n) {
                    answer++;
                }
                e++;
            }
            else {
                s++;
            }
        }
        
        
        return answer;
    }
}