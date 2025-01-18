import java.util.*;

class Solution {
    static Queue<Point> queue = new ArrayDeque<>();
    static Map<Integer, int[]> pointMap = new HashMap<>();
    static Map<String, Integer> routeMap = new HashMap<>();
    static int answer = 0;
    
    static class Point {
        int robot, x, y, nextIndex;
        public Point(int robot, int x, int y, int nextIndex) {
            this.robot=robot;
            this.x=x;
            this.y=y;
            this.nextIndex=nextIndex;
        }
    }
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public int solution(int[][] points, int[][] routes) {
       
        //포인트 좌표 저장
        for(int i=0; i<points.length; i++) {
            pointMap.put(i + 1, new int[]{points[i][0], points[i][1]});
        }
        for(int i=0; i<routes.length; i++) {
            int num = routes[i][0]; //현재 로봇의 출발 포인트 번호
            int x = points[num - 1][0];
            int y = points[num - 1][1];
            queue.offer(new Point(i + 1, x, y, 1));
            String newPos = x+" "+y;
            routeMap.put(newPos, routeMap.getOrDefault(newPos, 0) + 1);
        }
        for (int count : routeMap.values()) {
            if (count > 1) {
                answer++;
            }
        }
        solve(routes);
        return answer;
    }
    public void solve(int[][] routes) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            routeMap.clear();
            
            while(size-- > 0) {
                Point now = queue.poll();
                int nx = now.x, ny = now.y;
                int robotNum = now.robot;
                int nextIndex = now.nextIndex;
                int[] nextPoint = pointMap.get(routes[robotNum - 1][nextIndex]);    //다음 가야 할 포인트 넘버의 좌표
                
                // 최단 경로 이동 (r 우선)
                if (nx != nextPoint[0]) {
                    nx += (nextPoint[0] > nx) ? 1 : -1;
                } else if (ny != nextPoint[1]) {
                    ny += (nextPoint[1] > ny) ? 1 : -1;
                }
                //목적 포인트에 도착했는지
                if(nx == nextPoint[0] && ny == nextPoint[1]) {
                    if(nextIndex == routes[0].length - 1) { //현재 로봇의 가고자 하는 목적지 없어서 끝남
                        String newPos = nx + " " + ny;
                        routeMap.put(newPos, routeMap.getOrDefault(newPos, 0) + 1);
                        continue;
                    }
                    nextIndex++;
                }
                String newPos = nx + " " + ny;
                queue.offer(new Point(robotNum, nx, ny, nextIndex));
                routeMap.put(newPos, routeMap.getOrDefault(newPos, 0) + 1);
            }
            for (int count : routeMap.values()) {
                if (count > 1) {
                    answer++;
                }
            }
        }
    }
}