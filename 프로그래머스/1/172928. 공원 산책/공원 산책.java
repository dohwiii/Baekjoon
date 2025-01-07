import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<Character, Integer> directionMap = Map.of(
        'E', 2,
        'N', 1,
        'S', 0,
        'W', 3
    );

    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;
        int n = park.length;
        int m = park[0].length();

        // 시작 위치 찾기
        for (int i = 0; i < n; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf('S');
                break;
            }
        }

        // 경로 처리
        for (String route : routes) {
            char direction = route.charAt(0);
            int move = route.charAt(2) - '0';
            int dIndex = directionMap.get(direction);

            int nx = x, ny = y;

            // 이동 가능 여부 확인
            for (int i = 1; i <= move; i++) {
                int tx = x + dx[dIndex] * i;
                int ty = y + dy[dIndex] * i;

                if (tx < 0 || tx >= n || ty < 0 || ty >= m || park[tx].charAt(ty) == 'X') {
                    nx = x; // 이동 취소
                    ny = y;
                    break;
                }

                nx = tx;
                ny = ty;
            }

            x = nx;
            y = ny;
        }

        return new int[]{x, y};
    }
}