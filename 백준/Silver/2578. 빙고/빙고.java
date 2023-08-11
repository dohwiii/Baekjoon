import java.io.*;
import java.util.*;

public class Main {
    static int[][] bingo;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        visited = new boolean[5][5]; //사회자가 불러준 숫자 체크

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0; //몇번째 숫자에 빙고가 완성되는지
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                findNum(num);
                cnt++;
                if (isBingo()) {
                    System.out.println(cnt);
                    return;
                }
            }

        }




    }

    public static void findNum(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == num) {
                    visited[i][j] = true;
                }
            }
        }
    }
    public static boolean isBingo() {
        int bingoRowCnt = 0;
        int bingoColCnt = 0;
        int diagonalCnt = 0;

        for (int i = 0; i < 5; i++) {
            boolean isPossible = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    isPossible = false; //한 행이 다 그어지지 않았다면
                    break;
                }
            }
            if(isPossible)
            {
                bingoRowCnt++;
            }
        }
        for (int j = 0; j < 5; j++) {
            boolean isPossible = true;
            for (int i = 0; i < 5; i++) {
                if (!visited[i][j]) { //한 열이 다 그어지지 않았다면
                    isPossible = false;
                    break;
                }
            }
            if(isPossible)
            {
                bingoColCnt++;
            }
        }

        if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
            diagonalCnt++;
        }
        if (visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) {
            diagonalCnt++;
        }
        if (bingoRowCnt + bingoColCnt + diagonalCnt >= 3) {
            return true;
        }
        return false;
    }
}