class Solution
{
    static int N, M;
    static int[][] cnt;
    
    public int solution(int[][] board)
    {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        cnt = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 1) {
                    solve(i, j, board);
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                answer = Math.max(answer, cnt[i][j]);
            }
        }
        return answer * answer;
    }
    public void solve(int x, int y, int[][] board) {
        cnt[x][y] = 1;
        
        if(isBound(x - 1, y - 1) && isBound(x - 1, y) && isBound(x, y - 1)) {
            cnt[x][y] = Math.min(cnt[x - 1][y - 1], Math.min(cnt[x - 1][y], cnt[x][y - 1])) + 1;
        }
    }
    public boolean isBound(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }
}