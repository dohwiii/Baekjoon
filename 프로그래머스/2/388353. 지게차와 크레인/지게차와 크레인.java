import java.util.*;

class Solution {
    static int N, M;
    static char[][] map;
    // 상하좌우
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for (String req : requests) {
            if (req.length() == 2) {
                // 크레인: 해당 알파벳의 모든 컨테이너 제거
                char target = req.charAt(0);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = ' ';
                        }
                    }
                }
            } else {
                // 지게차: 현재 상태에서 접근 가능한 컨테이너만 제거
                char target = req.charAt(0);
                forklift(target);
            }
        }
        
        // 남은 컨테이너 수 세기
        int remain = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != ' ') remain++;
            }
        }
        return remain;
    }
    
    // 지게차 요청 처리: 접근성 판단 후 제거 (한 요청 당 동시 제거)
    public void forklift(char target) {
        // 1. 기존의 빈 셀을 기준으로 창고 외부와 연결된 영역(air 영역) 구하기
        boolean[][] air = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Pos> queue = new LinkedList<>();
        
        // 경계에 있는 빈 셀부터 시작
        for (int i = 0; i < N; i++) {
            if (map[i][0] == ' ') {
                queue.offer(new Pos(i, 0));
                visited[i][0] = true;
                air[i][0] = true;
            }
            if (map[i][M-1] == ' ') {
                if (!visited[i][M-1]) {
                    queue.offer(new Pos(i, M-1));
                    visited[i][M-1] = true;
                    air[i][M-1] = true;
                }
            }
        }
        for (int j = 0; j < M; j++) {
            if (map[0][j] == ' ') {
                if (!visited[0][j]) {
                    queue.offer(new Pos(0, j));
                    visited[0][j] = true;
                    air[0][j] = true;
                }
            }
            if (map[N-1][j] == ' ') {
                if (!visited[N-1][j]) {
                    queue.offer(new Pos(N-1, j));
                    visited[N-1][j] = true;
                    air[N-1][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == ' ') {
                    visited[nx][ny] = true;
                    air[nx][ny] = true;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }
        
        // 2. 접근 가능한 컨테이너(타겟 알파벳) 찾기  
        //    (단, 이번 요청에서 제거되는 컨테이너의 제거로 인한 연쇄 반응은 고려하지 않음)
        List<Pos> removeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == target) {
                    // 경계에 있으면 바로 접근 가능
                    if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                        removeList.add(new Pos(i, j));
                    } else {
                        // 인접 4방향 중 하나라도 air 영역이면 접근 가능
                        boolean accessible = false;
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (air[nx][ny]) {
                                accessible = true;
                                break;
                            }
                        }
                        if (accessible) removeList.add(new Pos(i, j));
                    }
                }
            }
        }
        
        // 3. 한 번에 접근 가능한 컨테이너 제거
        for (Pos pos : removeList) {
            map[pos.x][pos.y] = ' ';
        }
    }
}
