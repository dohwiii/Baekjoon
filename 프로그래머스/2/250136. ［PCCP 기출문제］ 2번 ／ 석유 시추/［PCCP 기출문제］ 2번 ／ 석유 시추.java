import java.util.*;

// 최대 500x500
// 0이면 빈 땅, 1이면 석유
// 석유 덩어리에 해당되면 그 석유덩어리 크기를 해당 칸에 다 적어놓음
// for 열 -> for 행해서 숫자가 0보다 큰게 있다면 더함 -> 나와서 최댓값 비교
class Solution {
    static int N, M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int totalCnt = 0;
    static int[][] nameLand;
    static boolean[][] seen;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        seen = new boolean[N][M];
        nameLand = new int[N][M];
        
        // 면적 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(land[i][j] == 1 && !seen[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        // 시추관 설치
        for(int col=0; col<M; col++) {  // 시추관 하나 설치
            boolean[] visited = new boolean[totalCnt + 1];
            int sumArea = 0;
            
            for(int row = 0; row < N; row++) {
                int name = nameLand[row][col];  // 석유덩어리의 이름
                if(!visited[name]) {
                    sumArea += land[row][col];
                    visited[name] = true;
                }
            }
            answer = Math.max(answer, sumArea);
        }
        
        
        // 시추관 하나를 설치해 뽑을 수 있는 가장 많은 석유량
        return answer;
    }
    private static void bfs(int x, int y, int[][] land) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> cells = new ArrayList<>();
        
        queue.offer(new Node(x, y));
        cells.add(new Node(x, y));
        seen[x][y] = true;
        int area = 1;
            
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for(int dir=0; dir<4; dir++) {
                int nx = now.x+dx[dir];
                int ny = now.y+dy[dir];
                
                if(nx<0||nx>=N||ny<0||ny>=M||seen[nx][ny]||land[nx][ny] == 0) {
                    continue;
                }
                seen[nx][ny] = true;
                queue.offer(new Node(nx, ny));
                cells.add(new Node(nx, ny));
                area++;
                
            }
        }
        if(area > 0) {
            totalCnt++;
        }

        for(Node n : cells) {
            nameLand[n.x][n.y] = totalCnt;
            land[n.x][n.y] = area;
        }
    }
    static class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}