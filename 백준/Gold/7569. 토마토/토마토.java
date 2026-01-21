import java.io.*;

public class Main {
    static int N, M, H;
    static int[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] queue;
    static int front = 0, back = 0;
    static int ripen, empty;

    public static void main(String[] args) throws IOException {
        // ⭐ 빠른 입력 방식
        M = readInt();   // 가로
        N = readInt();   // 세로
        H = readInt();   // 높이
        
        map = new int[H][N][M];
        queue = new int[N * M * H * 3];
        
        // 1: 익은 토마토 / 0: 익지 않은 토마토 / -1: 빈칸
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // ⭐ System.in.read()로 직접 읽기
                    int t;
                    int input = System.in.read();
                    
                    if (input == '-') {  // -1인 경우
                        System.in.read();  // '1' 읽고 버리기
                        t = -1;
                        empty++;
                    } else if (input == '0') {
                        t = 0;
                    } else {  // '1'
                        t = 1;
                        // 큐에 추가
                        queue[front++] = i;
                        queue[front++] = j;
                        queue[front++] = k;
                        ripen++;
                    }
                    
                    map[i][j][k] = t;
                    System.in.read();  // 공백이나 개행 문자 읽고 버리기
                }
            }
        }

        if (ripen == N * M * H - empty) {    // 모두 익은 토마토
            System.out.println(0);
            return;
        }
        
        int bfs = bfs();
        
        if (ripen != N * M * H - empty) {   // 다 익지 못했다면
            System.out.println(-1);
            return;
        }
        System.out.println(bfs);
    }

    private static int bfs() {
        int day = 0;

        while (back != front) {
            int levelStart = back;
            int levelEnd = front;
            
            if (ripen == N * M * H - empty) {
                return day;
            }

            for (int i = levelStart; i < levelEnd; i += 3) {
                int h = queue[i];
                int r = queue[i + 1];
                int c = queue[i + 2];

                for (int dir = 0; dir < 6; dir++) {
                    int nx = r + dx[dir];
                    int ny = c + dy[dir];
                    int nz = h + dz[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                        continue;
                    }
                    if (map[nz][nx][ny] != 0) {
                        continue;
                    }
                    
                    queue[front++] = nz;
                    queue[front++] = nx;
                    queue[front++] = ny;
                    
                    map[nz][nx][ny] = 1;
                    ripen++;
                }
            }
            
            back = levelEnd;
            day++;
        }
        return day;
    }

    // ⭐ 빠른 정수 읽기 함수
    static int readInt() throws IOException {
        int n = 0;
        while (true) {
            int input = System.in.read();
            if (input > 32) {  // 공백, 개행이 아니면
                n = (n << 3) + (n << 1) + (input & 15);
                // n * 10 + (input - '0')와 동일
                // (n << 3) = n * 8
                // (n << 1) = n * 2
                // n * 8 + n * 2 = n * 10
                // (input & 15) = input - '0' (아스키 코드에서 숫자 추출)
            } else {
                return n;
            }
        }
    }
}