import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;

    static List<Pos> chickenList = new ArrayList<>();
    static List<Pos> homeList = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //도시 개수 NxN
        M = Integer.parseInt(st.nextToken());   //치킨집 최대 개수
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenList.add(new Pos(i, j)); //치킨집 인덱스 저장
                } else if (map[i][j] == 1) {
                    homeList.add(new Pos(i, j));
                }
            }
        }
        boolean[] visited = new boolean[chickenList.size()];

        combination(visited, 0, chickenList.size(), M);

        System.out.println(minDistance);
    }

    public static void combination(boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            minDistance = Math.min(minDistance, calculate(visited));
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static int calculate(boolean[] visited) {
        int distance = 0;

        for (Pos home : homeList) {
            int minTemp = Integer.MAX_VALUE;

            for (int i = 0; i < chickenList.size(); i++) {
                if (visited[i]) {
                    Pos chic = chickenList.get(i);   //치킨집 주소
                    minTemp = Math.min(minTemp, Math.abs(home.x - chic.x) + Math.abs(home.y - chic.y));
                }
            }
            distance += minTemp;
        }

        return distance;

    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}