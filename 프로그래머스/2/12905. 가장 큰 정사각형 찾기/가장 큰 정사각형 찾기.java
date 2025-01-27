class Solution {
    public int solution(int[][] board) {
        int maxSide = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 1) {
                    if(i == 0 || j == 0) {  //가장자리
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
            
        }
        
        return maxSide * maxSide;
    }
}