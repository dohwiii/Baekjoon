import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Queue<Pos> queue = new ArrayDeque<>();
        int[] targetIndex = new int[routes.length + 1];
        
        for(int i=0; i<routes.length; i++) {
            int pointNum = routes[i][0];
            queue.offer(new Pos(points[pointNum - 1][0], points[pointNum - 1][1], i));
        }
                        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Map<String, Integer> collisions = new HashMap<>();   //충돌 횟수 체크
            System.out.println("사이즈 "+size);
                
            while(size-- > 0) {
                Pos now = queue.poll();
                int robotId = now.robotId;
                int targetPoint = routes[robotId][targetIndex[robotId]];    //4
                Pos target = new Pos(points[targetPoint - 1][0], points[targetPoint - 1][1]);
                int nx = now.x, ny = now.y;
                
                if(targetIndex[robotId] < routes[robotId].length) { //아직 가야할 포인트가 남았다면  
                    if(targetIndex[robotId] == routes[robotId].length - 1) {
                        if(nx == target.x && ny == target.y) {    //도달했다면 
                            continue;
                        }
                    }
                    if(nx != target.x) {
                        nx += (nx > target.x) ? -1 : 1;
                    }
                    else if(ny != target.y) {
                        ny += (ny > target.y) ? -1 : 1;
                    }
                    if(targetIndex[robotId] != routes[robotId].length - 1) {
                        if(nx == target.x && ny == target.y) {
                            targetIndex[robotId]++; //타겟 인덱스 증가(다음 타켓을 가리키도록)
                        }
                    }
                    queue.offer(new Pos(nx, ny, robotId));
                    String key = nx + " " + ny;
                    collisions.put(key, collisions.getOrDefault(key, 0) + 1);     
                }
            }
            for(String key : collisions.keySet()) {
                int value = collisions.get(key);
                if(value > 1) {
                    answer++;
                }
            }
            
        }
        return answer;
    }
    static class Pos {
        int x, y, robotId;
        public Pos(int x, int y, int robotId) {
            this.x=x;
            this.y=y;
            this.robotId=robotId;
        }
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}
