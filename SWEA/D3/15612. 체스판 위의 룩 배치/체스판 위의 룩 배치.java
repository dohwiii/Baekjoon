import java.io.*;
import java.util.*;

public class Solution {
    static ArrayList<Pos> rookList = new ArrayList<>();
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++)
        {
            isPossible = true;
            char[][] chess = new char[8][8];
            for (int j = 0; j < 8; j++) {
                String str = br.readLine();
                for (int k = 0; k < 8; k++) {
                    chess[j][k] = str.charAt(k);
                    if (chess[j][k] == 'O') {
                        rookList.add(new Pos(j, k));
                    }
                }
            }
            if (checkCondition(chess)) {
                System.out.println("#" + (i + 1) + " " + "yes");
            }
            else
                System.out.println("#" + (i + 1) + " " + "no");
        }

    }
    public static boolean checkCondition(char[][] chess) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[i][j] == 'O') {
                    if (!isSame(i, j, chess)) {
                        return false;
                    }
                    count++;
                }
            }
        }
        return count == 8;
    }

    public static boolean isSame(int row, int col, char[][] chess) {
        //(2,4) => (2,0)(2,1)(2,2)(2,3) ~ (2,7)

        for (int i = 0; i < 8; i++) {
            if (i == col) {
                continue;
            }
            if (chess[row][i] == 'O') {
                return false;
            }
        }
        for (int i = 0; i < 8; i++) {
            if (i == row) {
                continue;
            }
            if (chess[i][col] == 'O') {
                return false;
            }
        }
        return true;
    }
}
class Pos {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}