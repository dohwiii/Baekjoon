import java.util.*;

class Solution {
    static class Point {
        int robot, x, y, nextIndex;

        public Point(int robot, int x, int y, int nextIndex) {
            this.robot = robot;
            this.x = x;
            this.y = y;
            this.nextIndex = nextIndex;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        Map<Integer, int[]> pointMap = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        Map<String, Integer> positionCount = new HashMap<>();
        int answer = 0;

        // 포인트 좌표 저장
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, new int[]{points[i][0], points[i][1]});
        }

        // 초기 로봇 상태를 큐에 삽입
        for (int i = 0; i < routes.length; i++) {
            int startPoint = routes[i][0];
            int x = points[startPoint - 1][0];
            int y = points[startPoint - 1][1];
            queue.offer(new Point(i, x, y, 1)); // 로봇 번호, 초기 좌표, 다음 목적지 인덱스
            String positionKey = x + "," + y;
            positionCount.put(positionKey, positionCount.getOrDefault(positionKey, 0) + 1);
        }

        // 초기 충돌 체크
        for (int count : positionCount.values()) {
            if (count > 1) {
                answer++;
            }
        }

        // 로봇 이동 시뮬레이션
        while (!queue.isEmpty()) {
            int size = queue.size();
            positionCount.clear(); // 매 시간마다 위치 카운트를 초기화

            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                int[] nextPoint = pointMap.get(routes[current.robot][current.nextIndex]);
                int nx = current.x, ny = current.y;

                // 최단 경로 이동 (r 우선)
                if (nx != nextPoint[0]) {
                    nx += (nextPoint[0] > nx) ? 1 : -1;
                } else if (ny != nextPoint[1]) {
                    ny += (nextPoint[1] > ny) ? 1 : -1;
                }

                // 다음 목적지에 도달했으면 인덱스 업데이트
                if (nx == nextPoint[0] && ny == nextPoint[1]) {
                    if (current.nextIndex < routes[current.robot].length - 1) {
                        current.nextIndex++;
                    } else {
                        // 마지막 목적지 도달
                        String positionKey = nx + "," + ny;
                        positionCount.put(positionKey, positionCount.getOrDefault(positionKey, 0) + 1);
                        continue; // 큐에 추가하지 않음
                    }
                }

                // 로봇 상태 업데이트
                queue.offer(new Point(current.robot, nx, ny, current.nextIndex));
                String positionKey = nx + "," + ny;
                positionCount.put(positionKey, positionCount.getOrDefault(positionKey, 0) + 1);
            }

            // 충돌 체크
            for (int count : positionCount.values()) {
                if (count > 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}