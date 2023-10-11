import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int coreMax;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Pos> coreList;
    static List<Pos> coreWireList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); //NxN
            int[][] map = new int[N][N];
            coreList = new ArrayList<>();
            coreMax = Integer.MIN_VALUE;
            coreWireList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); //1:core
                }
            }
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (map[i][j] == 1) {
                        coreList.add(new Pos(i, j));
                    }
                }
            }
            connectCore(0, 0, map, 0);
            int ans = Integer.MAX_VALUE;
            for (Pos v : coreWireList) {
                if (v.x == coreMax) {
                    ans = Math.min(ans, v.y);
                }
            }

            sb.append("#" + (t + 1) + " ");
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb);

    }


    public static void connectCore(int coreCnt, int depth, int[][] map, int wireCnt) {
        if (depth == coreList.size()) { //탐색 끝
            coreMax = Math.max(coreMax, coreCnt);
            coreWireList.add(new Pos(coreCnt, wireCnt));
            return;
        }
        //남은 코어 수
        int remainCore = coreList.size() - (depth - coreCnt);
        if (remainCore < coreMax) {
            return;
        }

        //현재 탐색하고 있는 코어 좌표
        int x = coreList.get(depth).x;
        int y = coreList.get(depth).y;


        for (int i = 0; i < 4; i++) {
            int tempR = dx[i];
            int tempC = dy[i];

            int cnt = 0; //전선 길이
            boolean isArrive = false; //현재 코어가 전선을 완성했는가

            //배열 복사
            int[][] copyMap = new int[N][N];
            for (int j = 0; j < N; j++) {
                copyMap[j] = map[j].clone();
            }
            while (true) {
                if (x + tempR >= 0 && x + tempR < N && y + tempC >= 0 && y + tempC < N) {
                    if (copyMap[x + tempR][y + tempC] != 0) {
                        isArrive = false;
                        break;
                    }
                    copyMap[x + tempR][y + tempC] = 2; //전선 생성
                    cnt++; //전선 길이

                    if (tempR > 0) {
                        tempR++;
                    } else if (tempR < 0) {
                        tempR--;
                    }
                    if (tempC > 0) {
                        tempC++;
                    } else if (tempC < 0) {
                        tempC--;
                    }
                } else { //범위밖이면 전선 연결 성공
                    isArrive = true;
                    connectCore(coreCnt + 1, depth + 1, copyMap, wireCnt + cnt);
                    break;
                }
            }
            if (!isArrive) { //도착하지 못했다면
                //다음 코어 탐색, 전선 만들지 않음, 전선 개수 동일
                connectCore(coreCnt, depth + 1, map, wireCnt);
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