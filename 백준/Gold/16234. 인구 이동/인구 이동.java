import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static boolean isOpen;
    static int cnt, people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        // 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선 -> 오늘 하루 동안 open

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 국경선 모두 open
        // 2. 인구이동
        // 3. 인구수 배분

        int day = 0;
        // 하루마다 리셋
        while (true) {
            List<int[]> openNation = new ArrayList<>();
            visited = new boolean[N][N];
            isOpen = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        cnt = 0;    // 연합 칸 수
                        people = 0; // 연합의 인구수
                        openNation = new ArrayList<>();
                        openBorder(i, j, openNation);   // 하나의 연합 생성
                        int dividePeople = people / cnt;
                        for (int[] c : openNation) {
                            int x = c[0];
                            int y = c[1];
                            map[x][y] = dividePeople;
                        }

                    }
                }
            }
            // 더이상 열 국경선이 없음
            if (!isOpen) {
                break;
            }
            day++;

        }
        System.out.println(day);


    }

    private static void openBorder(int x, int y, List<int[]> list) {
        // 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선 -> 오늘 하루 동안 open
        visited[x][y] = true;
        cnt++;
        people += map[x][y];
        list.add(new int[]{x, y});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                continue;
            }
            int diff = Math.abs(map[nx][ny] - map[x][y]);
            if (diff >= L && diff <= R) {   // 국경선 open
                isOpen = true;
                openBorder(nx, ny, list);
            }

        }
    }
}