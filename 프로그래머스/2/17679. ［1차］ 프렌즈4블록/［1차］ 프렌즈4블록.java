import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static List<int[]> blocksToRemove;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = m;
        M = n;
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            visited = new boolean[N][M];
            blocksToRemove = new ArrayList<>();
            int cnt = 0;

            // 게임 시작: 4칸 완성 찾기
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < M - 1; j++) {
                    if (map[i][j] != '0' && isSame(i, j)) { // 4칸 완성
                        cnt++;
                    }
                }
            }

            if (cnt == 0) { // 제거할 블록이 없으면 종료
                break;
            }

            // 블록 제거
            for (int[] pos : blocksToRemove) {
                int x = pos[0];
                int y = pos[1];
                if (map[x][y] != '0') { // 중복 제거 방지
                    map[x][y] = '0';
                    answer++;
                }
            }

            // 빈 공간 채우기 (아래로 내리기)
            for (int col = 0; col < M; col++) {
                int emptyRow = N - 1;
                for (int row = N - 1; row >= 0; row--) {
                    if (map[row][col] != '0') {
                        map[emptyRow--][col] = map[row][col];
                    }
                }
                while (emptyRow >= 0) {
                    map[emptyRow--][col] = '0';
                }
            }
        }

        return answer;
    }

    public boolean isSame(int x, int y) {
        char c = map[x][y];
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= N || ny >= M || map[nx][ny] != c) {
                return false;
            }
        }
        // 4칸 완성된 좌표 추가
        blocksToRemove.add(new int[] {x, y});
        blocksToRemove.add(new int[] {x + 1, y});
        blocksToRemove.add(new int[] {x, y + 1});
        blocksToRemove.add(new int[] {x + 1, y + 1});
        return true;
    }
}
