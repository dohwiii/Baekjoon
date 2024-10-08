import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0}; // x 방향 이동 (r)
    static int[] dy = {0, 0, 1, -1}; // y 방향 이동 (c)
    static Queue<Pos> queue = new ArrayDeque<>();
    static Map<Integer, Pos> hMap = new HashMap<>();
    static boolean[][][] visited;
    static int[][] robotsAt;
    static int[] nextTargetIndex;
    static Map<Integer, Integer> collisions = new HashMap<>();

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robot = routes.length;  // 로봇 개수
        visited = new boolean[robot + 1][101][101]; // 방문 기록
        robotsAt = new int[101][101]; // 각 좌표에 있는 로봇 수
        nextTargetIndex = new int[robot + 1]; // 각 로봇의 다음 목적지 인덱스

        // 포인트 표시
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            hMap.put(i + 1, new Pos(x, y)); // 포인트 좌표 저장 (1-based)
        }
        int index = 0;
        for(int[] route : routes) {
            int startPoint = route[0];
            int r = points[startPoint-1][0];
            int c = points[startPoint-1][1];
            queue.offer(new Pos(index+1, r, c));
            index++;
        }
        // 충돌 횟수 계산
        answer += solve(routes);
        
        return answer;
    }

    public static int solve(int[][] routes) {
        int collisions = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<String, Integer> tempRobotsAt = new HashMap<>();  // 임시 좌표별 로봇 수 기록

            // 모든 로봇이 한 번씩 이동함
            while (size-- > 0) {
                Pos current = queue.poll();
                int robotId = current.num;
                int targetIdx = nextTargetIndex[robotId];  // 로봇의 현재 목표 인덱스

                // 로봇의 모든 경로를 완료한 경우 처리하지 않음
                if (targetIdx >= routes[robotId-1].length) {
                    continue;
                }

                // 로봇의 다음 목표 좌표
                int targetPoint = routes[robotId-1][targetIdx];
                Pos targetPos = hMap.get(targetPoint);

                int newX = current.x;
                int newY = current.y;

                // r 좌표를 먼저 맞춤
                if (newX != targetPos.x) {
                    newX += (targetPos.x > newX) ? 1 : -1;  // r 방향 이동
                }
                // r이 맞춰졌으면 c 좌표를 맞춤
                else if (newY != targetPos.y) {
                    newY += (targetPos.y > newY) ? 1 : -1;  // c 방향 이동
                }

                // 로봇이 새로운 좌표로 이동한 상태를 임시 기록
                String newPosition = newX + "," + newY;
                tempRobotsAt.put(newPosition, tempRobotsAt.getOrDefault(newPosition, 0) + 1);

                queue.offer(new Pos(robotId, newX, newY));  // 다음 이동을 위해 큐에 추가

                // 목표 지점에 도달한 경우, 다음 목표로 이동
                if (newX == targetPos.x && newY == targetPos.y) {
                    nextTargetIndex[robotId]++;
                }
            }

            // 모든 로봇이 이동한 후 충돌을 체크
            for (String pos : tempRobotsAt.keySet()) {
                int count = tempRobotsAt.get(pos);
                if (count > 1) {
                    collisions += 1;  // 충돌이 발생한 경우, 중복되지 않게 한 번만 카운트
                }
            }
        }

        return collisions;
    }

    static class Pos {
        int num, x, y;
        public Pos(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
