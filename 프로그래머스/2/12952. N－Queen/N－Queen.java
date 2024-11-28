class Solution {
    static int[] chess;
    static int answer;
    public int solution(int n) {
        chess = new int[n];
        solve(0, n);
        return answer;
    }
    public void solve(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            chess[row] = i;
            if(isSafe(row)) {
                solve(row + 1, n);
            }
        }
    }
    public boolean isSafe(int row) {
        for(int i=0; i<row; i++) {
            if(chess[i] == chess[row] || Math.abs(row - i) == Math.abs(chess[row] - chess[i])) {
                return false;
            }
        }
        return true;
    }
}