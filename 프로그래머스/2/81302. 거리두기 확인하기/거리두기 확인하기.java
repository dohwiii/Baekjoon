import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static boolean isPossible;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            map = new char[5][5];
            visited = new boolean[5][5];
            isPossible = true;

            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (map[r][c] == 'P' && !visited[r][c]) {
                        dfs(r, c, 0);
                        if (!isPossible) break; // 한 번이라도 거리두기 실패 시 종료
                    }
                }
                if (!isPossible) break;
            }
            answer[i] = isPossible ? 1 : 0;
        }
        return answer;
    }

    private void dfs(int x, int y, int distance) {
        if (distance > 2 || !isPossible) return; // 거리 2 이상 시 탐색 중단
        if (distance > 0 && map[x][y] == 'P') { // 응시자 발견 시 거리두기 실패
            isPossible = false;
            return;
        }

        visited[x][y] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                if (map[nx][ny] == 'X') continue; // 파티션일 경우 지나가지 않음
                dfs(nx, ny, distance + 1); // 거리 2 이하인 경우 계속 탐색
            }
        }
    }
}
