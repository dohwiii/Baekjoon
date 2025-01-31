import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while (true) {
            boolean[][] visited = new boolean[m][n];
            boolean hasBlockToRemove = false;
            
            // 1. 제거할 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != ' ' && 
                        map[i][j] == map[i][j + 1] && 
                        map[i][j] == map[i + 1][j] && 
                        map[i][j] == map[i + 1][j + 1]) {
                        visited[i][j] = visited[i][j + 1] = visited[i + 1][j] = visited[i + 1][j + 1] = true;
                        hasBlockToRemove = true;
                    }
                }
            }
            
            if (!hasBlockToRemove) break;
            
            // 2. 블록 제거 및 개수 세기
            int removedBlocks = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        map[i][j] = ' ';
                        removedBlocks++;
                    }
                }
            }
            answer += removedBlocks;
            
            // 3. 블록 내리기 (열별로 처리)
            for (int j = 0; j < n; j++) {
                int writeIdx = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        map[writeIdx--][j] = map[i][j];
                    }
                }
                while (writeIdx >= 0) {
                    map[writeIdx--][j] = ' ';
                }
            }
        }
        
        return answer;
    }
}
