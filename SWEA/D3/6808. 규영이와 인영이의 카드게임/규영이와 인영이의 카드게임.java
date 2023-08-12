import java.io.*;
import java.util.*;

public class Solution {
    static boolean[] cards;
    static int[] gu;
    static int[] in;
    static boolean[] isSelected;
    static int[] remainNumbers;
    static int win;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            cards = new boolean[18];
            in = new int[9]; //인영
            gu = new int[9]; //규영
            isSelected = new boolean[9];
            remainNumbers = new int[9];
            win = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                gu[j] = Integer.parseInt(st.nextToken());
                cards[gu[j] - 1] = true; //규영이 카드 true
            }
            int index = 0;
            //인영이 카드 채우기
            for (int j = 0; j < 18; j++) {
                if (!cards[j]) {
                    remainNumbers[index++] = j + 1;
                }
            }
            cardGame(0);
            sb.append("#" + (i + 1)).append(" ").append(win).append(" ").append(362880 - win).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void cardGame(int cnt) {
        if (cnt == 9) { //게임 끝
            int gu_point = 0;
            int in_point = 0;
            for (int i = 0; i < 9; i++) {
                if (gu[i] > in[i]) { //규영 승
                    gu_point += gu[i] + in[i];
                } else if (gu[i] < in[i]) {
                    in_point += gu[i] + in[i];
                }
            }
            if (gu_point > in_point) {
                win++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            in[cnt] = remainNumbers[i];
            cardGame(cnt + 1);
            isSelected[i] = false;
        }
    }
}