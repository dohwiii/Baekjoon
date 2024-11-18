import java.util.*;

class Solution {
    static char[][] map;
    static int N, M;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static List<int[]> blocksToRemove;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = m;
        M = n;
        map = new char[N][M];

        for(int i=0; i<board.length; i++) {
            map[i] = board[i].toCharArray();
        }
        while(true) {
            blocksToRemove = new ArrayList<>();  //4칸 완성 좌표 담을 Set
            int cnt = 0;
            //게임 시작
            for(int i=0; i < N - 1; i++) {
                for(int j=0; j < M - 1; j++) {
                    if(map[i][j] != '0' && isSame(i, j)) {  //4칸 완성
                        cnt++;
                    }
                }
            }
            if(cnt == 0) {  //게임 종료
                break;
            }
            
            //블록 제거
            for(int[] pos : blocksToRemove) {
                int x = pos[0];
                int y = pos[1];
                if(map[x][y] != '0') {  //중복 제거 방지
                    map[x][y] = '0';
                    answer++;
                }
            }
            
            //빈 공간 채우기 (아래로 내리기)
            for(int i=0; i<M; i++) {    //열(가로)
                int emptyRow = N - 1;
                for(int j=N-1; j>=0; j--) {    //행(세로)
                    if(map[j][i] != '0') {
                        map[emptyRow--][i] = map[j][i];
                    }
                }
                while(emptyRow >= 0) {
                    map[emptyRow--][i] = '0';
                }  
            }
        }
        
        return answer;
    }
    public boolean isSame(int x, int y) {
        for(int i=0; i<3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != map[x][y]) {
                return false;
            }
        }
        // 4칸 완성된 좌표 추가
        blocksToRemove.add(new int[] {x, y});
        blocksToRemove.add(new int[] {x + 1, y});
        blocksToRemove.add(new int[] {x, y + 1});
        blocksToRemove.add(new int[] {x + 1, y + 1});
        return true;
        
    }
}