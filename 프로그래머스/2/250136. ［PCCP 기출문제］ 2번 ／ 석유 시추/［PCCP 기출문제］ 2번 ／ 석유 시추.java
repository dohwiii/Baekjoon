import java.util.*;

// 최대 500x500
// 0이면 빈 땅, 1이면 석유
// 석유 덩어리에 해당되면 그 석유덩어리 크기를 해당 칸에 다 적어놓음
// for 열 -> for 행해서 숫자가 0보다 큰게 있다면 더함 -> 나와서 최댓값 비교

// 내가 놓쳤던 포인트
// 1. 'ㄷ'자 모형으로 같은 석유덩어리가 있는 경우에 시추관 검사할 때 다른 덩어리로 인식 
// 2. bfs 끝난 후 land 배열과 nameLand 배열에 덩어리 크기와 순번을 새길 때 N*M을 다 도는 것이 아니라 List에 덩어리 좌표만 담아서 해당 좌표들만 표시

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
        
        int[] lastColumn = new int[totalCnt + 1];   // 해당 덩어리를 몇번째 열까지 저장했는지 확인
        // 시추관 설치
        for(int col=0; col<M; col++) {  // 시추관 하나 설치
            int sumArea = 0;
            
            for(int row = 0; row < N; row++) {
                int name = nameLand[row][col];  // 석유덩어리의 이름
                if(lastColumn[name] != col + 1) {
                    lastColumn[name] = col + 1;
                    sumArea += land[row][col];
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