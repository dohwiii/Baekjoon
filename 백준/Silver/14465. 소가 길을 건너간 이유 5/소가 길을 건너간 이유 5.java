
import java.io.*;
import java.util.*;

public class Main {
    static int N, K, B;
    static int[] crosswalk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //신호등 개수
        K = Integer.parseInt(st.nextToken());   //연속 K개 신호등
        B = Integer.parseInt(st.nextToken());   //고장난 신호등 개수
        crosswalk = new int[N + 1];

        //고장난 신호등 번호는 1
        for (int i = 0; i < B; i++) {
            crosswalk[Integer.parseInt(br.readLine())] = 1;
        }
        int result = 0; //고쳐야하는 신호등의 수

        for (int i = 1; i <= K; i++) {
            if (crosswalk[i] == 1) {
                result++;
            }
        }
        int cnt = result;

        for (int i = 2; i <= N - K + 1; i++) {
            int end = i + K - 1; //2+6-1 = 7

            if (crosswalk[i - 1] == 1) {
                cnt--;
            }
            if (crosswalk[end] == 1) {
                cnt++;
            }
            result = Math.min(result, cnt);
        }
        System.out.println(result);
    }
}
