class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[] mats, String[][] park) {
        int maxLength = 0;
        
        int[][] dp = new int[park.length][park[0].length];
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        int answer = -1;
        for(int l : mats) {
            if(l <= maxLength) {
                answer = Math.max(answer, l);
            }
        }
        
        return answer;
    }
}