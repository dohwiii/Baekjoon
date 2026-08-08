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
       
        for(int x=0; x<m; x++) {
            for(int y=0; y<n; y++) {
                if(map[x][y] == '0') {  // '0'인 블록들끼리 2x2 블록이라고 착각하지 않기
                    continue;
                } 
                char c = map[x][y];
                
                if(x+1 < m && y+1 < n) {
                    if(c == map[x+1][y] && c == map[x+1][y+1] && c == map[x][y+1]) {
                        is4block[x][y] = is4block[x+1][y] = true;
                        is4block[x][y+1] = is4block[x+1][y+1] = true;
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
                    // 0인 블록들이 아래에 있다면 1개 꺼내서 매칭
                    if(!queue.isEmpty()) {
                        int nr = queue.poll();
                        map[nr][c] = map[r][c];
                        map[r][c] = '0';
                        queue.offer(r);
                    }
                }
            }
            
        }
    }
}