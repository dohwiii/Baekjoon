import java.util.*;

class Solution {
    static char[][] map;
    static int m, n;
    static int count;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        this.m = m;
        this.n = n;
        map = new char[m][n];
        
        for(int i=0; i<board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while(findBlock()) {
            makeDown();
        }

        return count;
    }
    private static boolean findBlock() {
        boolean[][] is4block = new boolean[m][n];
        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
        Queue<int[]> queue = new ArrayDeque<>();
       
        for(int x=0; x<m; x++) {
            for(int y=0; y<n; y++) {
                if(map[x][y] == '0') {
                    continue;
                } 
                int isFound = 1;
                queue = new ArrayDeque<>();
                queue.offer(new int[]{x, y});
                 
                for(int dir = 0; dir < 3; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    
                    if(nx < 0 || nx >=m || ny<0 || ny>=n) {
                        continue;
                    }
                    if(map[x][y] != map[nx][ny]) {  // 같은 블록이 아님
                        isFound = 0;
                        while(!queue.isEmpty()) {
                            queue.poll();
                        }
                        break;
                    }
                    isFound++;
                    queue.offer(new int[]{nx, ny});
                }
                if(isFound == 4) {   // 2x2 같은 블록
                    while(!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        is4block[arr[0]][arr[1]] = true;    // 2x2 블록 완성
                    } 
                }
                else {
                    while(!queue.isEmpty()) {   // 2x2 아니니깐 다 버리기
                        queue.poll();
                    }
                }
                
            }
        }
        int cnt = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(is4block[i][j]) {
                    map[i][j] = '0';
                    cnt++;
                    count++;
                }
            }
        }   
        if(cnt == 0) {
            return false;
        }
        return true;
    }
    private static void makeDown() {    // '0' 인 블록들 끌어내리기
        
        for(int c = 0; c < n; c++) {    // 열
            Queue<Integer> queue = new ArrayDeque<>();
            
            for(int r = m-1; r>=0; r--) {
                if(map[r][c] == '0') {
                    queue.offer(r);
                }
                else {  // 숫자인 블록
                    // 0인 블록들이 아래에 있다면
                    while(!queue.isEmpty()) {
                        int nr = queue.poll();
                        map[nr][c] = map[r][c];
                        map[r][c] = '0';
                        queue.offer(r);
                        break;
                    }
                }
            }
            
        }
    }
}