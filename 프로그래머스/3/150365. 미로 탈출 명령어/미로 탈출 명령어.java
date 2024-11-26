import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dirChars = {'d', 'l', 'r', 'u'};
    static String answer = "impossible";
    static int N, M;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;

        // 초기 조건: 도달 불가능한 경우
        int minDistance = Math.abs(x - r) + Math.abs(y - c);
        if (minDistance > k || (k - minDistance) % 2 != 0) {
            return "impossible";
        }

        // DFS 시작
        dfs(x - 1, y - 1, r - 1, c - 1, k, new StringBuilder());
        return answer;
    }

    public void dfs(int x, int y, int r, int c, int remainingSteps, StringBuilder path) {
        // 종료 조건: 탈출 성공
        if (remainingSteps == 0) {
            if (x == r && y == c) {
                answer = path.toString();
            }
            return;
        }

        // 가지치기: 현재 위치에서 탈출 지점까지 도달 불가능한 경우
        int distanceToTarget = Math.abs(x - r) + Math.abs(y - c);
        if (distanceToTarget > remainingSteps) {
            return;
        }

        // 사전순 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 격자 바깥으로 나가는 경우 무시
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            // 이동
            path.append(dirChars[i]);
            dfs(nx, ny, r, c, remainingSteps - 1, path);

            // 상태 복구
            path.deleteCharAt(path.length() - 1);

            // 탈출 경로를 이미 찾은 경우 더 이상 탐색하지 않음
            if (!answer.equals("impossible")) {
                return;
            }
        }
    }
}
