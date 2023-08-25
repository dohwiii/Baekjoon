import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Pos> coreList;
    static int maxCoreCnt;
    static List<Core> coreWireList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); //크기
            int[][] map = new int[N][N];
            coreList = new ArrayList<>();
            coreWireList = new ArrayList<>();
            maxCoreCnt = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //가장자리 제외
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (map[i][j] == 1) { //core
                        coreList.add(new Pos(i, j)); //리스트 추가
                    }
                }
            }
            makeWire(map, 0, 0, 0, 0);
            Collections.sort(coreWireList);
            int minWireCnt = Integer.MAX_VALUE;
            for (Core c : coreWireList) {
                if (c.coreCnt == maxCoreCnt) {
                    minWireCnt = Math.min(minWireCnt, c.wireCnt);
                }
            }
            sb.append("#").append(t + 1).append(" ");
            sb.append(minWireCnt);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void makeWire(int[][] map, int coreCnt, int wireCnt, int checkedCore, int depth) { //현재 코어 위치
        if (depth == coreList.size()) {
            maxCoreCnt = Math.max(maxCoreCnt, coreCnt); //코어 최대개수
            coreWireList.add(new Core(coreCnt, wireCnt)); //코어 개수와 전선 개수 리스트 저장
            return;
        }
        int remainCore = coreList.size() - depth + coreCnt; //남은 코어수
        if (remainCore < maxCoreCnt) {
            return;
        }
        int x = coreList.get(depth).x;
        int y = coreList.get(depth).y;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 복사
            int[][] copy = new int[N][N];
            for (int j = 0; j < N; j++) {
                copy[j] = map[j].clone();
            }
            int wCnt = 0; //전선 길이
            boolean isConnected = false; //전선이 연결되었는가
            while (true) {
                //범위 안이라면
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (copy[nx][ny] == 2 || copy[nx][ny] == 1) { //이미 다른 전선이 있거나, 다른 core가 있다면 방향 전환
                        break;
                    }
                    if (copy[nx][ny] == 0) { //빈칸이라면
                        copy[nx][ny] = 2; //전선 생성
                        nx += dx[i];
                        ny += dy[i];
                        wCnt++; //전선 개수
                    }
                } else { //범위 밖이라면 전선 다 만들어진 것
                    isConnected = true;
                    makeWire(copy, coreCnt + 1, wireCnt + wCnt, checkedCore + 1, depth + 1); //해당 코어 선택
                    break;
                }
            }
            if (!isConnected) { //이 코어를 선택하지 않았을 때
                makeWire(map, coreCnt, wireCnt, checkedCore + 1, depth + 1);
            }
        }
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Core implements Comparable<Core> {
    int coreCnt, wireCnt;

    public Core(int coreCnt, int wireCnt) {
        this.coreCnt = coreCnt;
        this.wireCnt = wireCnt;
    }

    @Override
    public int compareTo(Core o) {
        if (o.coreCnt == this.coreCnt) {
            return this.wireCnt - o.wireCnt;
        }
        return o.coreCnt - this.coreCnt;
    }
}
