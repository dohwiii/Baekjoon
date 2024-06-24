
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dolls;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dolls = new int[N];
        int idx = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {    //라이언
                dolls[idx++] = i;    //라이언 인형의 인덱스를 저장
            }
        }
        if (idx < K) {
            result = -1;
        }
        else {
            result = dolls[K - 1] - dolls[0] + 1;
            for (int i = 1; i < idx - K + 1; i++) {
                int end = i + K - 1;
                result = Math.min(result, dolls[end] - dolls[i] + 1);
            }
        }
        System.out.println(result);

    }
}
