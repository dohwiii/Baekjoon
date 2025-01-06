import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        answer = solve(board[h][w], h, w, board);
        
        return answer;
    }
    public int solve(String color, int x, int y, String[][] board) {
        int cnt = 0;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || !board[nx][ny].equals(color)) {
                continue;
            }
            cnt++;
        }
        return cnt;
    }
}